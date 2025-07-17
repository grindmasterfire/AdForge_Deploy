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

data class RewardEntry(val raffleId: String, val timestamp: Long, val coins: Int?)

class RewardHistoryViewModel : ViewModel() {
    private val _rewards = MutableStateFlow<List<RewardEntry>>(emptyList())
    val rewards: StateFlow<List<RewardEntry>> = _rewards

    private val db = FirebaseDatabase.getInstance()
    private val userId = "testUser" // Replace with dynamic user ID logic

    init {
        val verifiedRef = db.getReference("verifiedClaims/\")
        verifiedRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val rewardList = mutableListOf<RewardEntry>()
                val group = snapshot.children

                for (raffleSnap in group) {
                    val raffleId = raffleSnap.key ?: continue
                    val timestamp = raffleSnap.getValue(Long::class.java) ?: continue

                    // Fetch coins from parallel path
                    db.getReference("raffleWinners/\/\")
                        .addListenerForSingleValueEvent(object : ValueEventListener {
                            override fun onDataChange(coinSnap: DataSnapshot) {
                                val coins = coinSnap.getValue(Int::class.java)
                                rewardList.add(RewardEntry(raffleId, timestamp, coins))
                                _rewards.value = rewardList.toList()
                            }

                            override fun onCancelled(error: DatabaseError) {}
                        })
                }
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }
}

