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

data class CrewPrize(val rank: String, val crewId: String, val reward: Int, val perMember: Int?)

class CrewPrizeTierViewModel : ViewModel() {
    private val _prizes = MutableStateFlow<List<CrewPrize>>(emptyList())
    val prizes: StateFlow<List<CrewPrize>> = _prizes

    private val db = FirebaseDatabase.getInstance()
    private val cycle = "JULY2025" // Replace with dynamic contest cycle logic

    init {
        val tiersRef = db.getReference("crewRewards/\/tiers")
        val resultList = mutableListOf<CrewPrize>()

        tiersRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(tiersSnap: DataSnapshot) {
                for (rankSnap in tiersSnap.children) {
                    val rank = rankSnap.key ?: continue
                    val entry = rankSnap.children.firstOrNull() ?: continue
                    val crewId = entry.key ?: continue
                    val reward = entry.getValue(Int::class.java) ?: continue

                    db.getReference("crewScores/\/activeUsers")
                        .addListenerForSingleValueEvent(object : ValueEventListener {
                            override fun onDataChange(userSnap: DataSnapshot) {
                                val members = userSnap.getValue(Long::class.java)?.toInt() ?: 1
                                val perMember = if (members > 0) reward / members else reward
                                resultList.add(CrewPrize(rank, crewId, reward, perMember))
                                _prizes.value = resultList
                            }

                            override fun onCancelled(error: DatabaseError) {}
                        })
                }
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }
}

