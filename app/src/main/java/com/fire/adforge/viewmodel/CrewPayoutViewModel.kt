import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.database.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class CrewPayout(val crewId: String, val totalCoins: Int, val userCount: Int, val avgPerUser: Int)

class CrewPayoutViewModel : ViewModel() {
    private val _crewPayouts = MutableStateFlow<List<CrewPayout>>(emptyList())
    val crewPayouts: StateFlow<List<CrewPayout>> = _crewPayouts

    private val db = FirebaseDatabase.getInstance()

    init {
        val queueRef = db.getReference("payoutQueue")
        val crewMap = mutableMapOf<String, MutableList<Int>>()

        queueRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(queueSnap: DataSnapshot) {
                val totalUsers = queueSnap.childrenCount
                var processed = 0L

                for (userSnap in queueSnap.children) {
                    val userId = userSnap.key ?: continue
                    val map = userSnap.value as? Map<*, *> ?: continue
                    val status = map["status"] as? String ?: continue
                    if (status != "completed") continue

                    val amount = (map["amount"] as? Long)?.toInt() ?: continue
                    val crewRef = db.getReference("userMeta/\/crew")

                    crewRef.addListenerForSingleValueEvent(object : ValueEventListener {
                        override fun onDataChange(crewSnap: DataSnapshot) {
                            val crewId = crewSnap.getValue(String::class.java) ?: "unassigned"
                            crewMap.getOrPut(crewId) { mutableListOf() }.add(amount)
                            processed++
                            if (processed >= totalUsers) {
                                _crewPayouts.value = crewMap.map { (crew, coins) ->
                                    val total = coins.sum()
                                    val users = coins.size
                                    val avg = if (users > 0) total / users else 0
                                    CrewPayout(crew, total, users, avg)
                                }.sortedByDescending { it.totalCoins }
                            }
                        }

                        override fun onCancelled(error: DatabaseError) {}
                    })
                }
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }
}

