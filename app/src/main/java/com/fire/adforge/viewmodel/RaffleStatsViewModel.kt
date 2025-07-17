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

data class RaffleStat(val raffleId: String, val entries: Int, val winners: Int, val verified: Int)

class RaffleStatsViewModel : ViewModel() {
    private val _stats = MutableStateFlow<List<RaffleStat>>(emptyList())
    val stats: StateFlow<List<RaffleStat>> = _stats

    private val db = FirebaseDatabase.getInstance()

    init {
        val raffleIds = listOf("RAFFLE123", "RAFFLE124") // Replace with dynamic logic if needed

        val resultList = mutableListOf<RaffleStat>()

        for (raffleId in raffleIds) {
            val entriesRef = db.getReference("raffleEntries/\")
            val winnersRef = db.getReference("raffleWinners/\")
            val verifiedRef = db.getReference("verifiedClaims/\")

            entriesRef.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(entrySnap: DataSnapshot) {
                    val entryCount = entrySnap.childrenCount.toInt()

                    winnersRef.addListenerForSingleValueEvent(object : ValueEventListener {
                        override fun onDataChange(winnerSnap: DataSnapshot) {
                            val winnerCount = winnerSnap.childrenCount.toInt()

                            verifiedRef.addListenerForSingleValueEvent(object : ValueEventListener {
                                override fun onDataChange(verifiedSnap: DataSnapshot) {
                                    val verifiedCount = verifiedSnap.childrenCount.toInt()

                                    resultList.add(RaffleStat(raffleId, entryCount, winnerCount, verifiedCount))
                                    _stats.value = resultList.toList()
                                }

                                override fun onCancelled(error: DatabaseError) {}
                            })
                        }

                        override fun onCancelled(error: DatabaseError) {}
                    })
                }

                override fun onCancelled(error: DatabaseError) {}
            })
        }
    }
}

