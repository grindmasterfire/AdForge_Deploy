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

data class CrewScore(val crewId: String, val totalCoins: Int, val activeUsers: Int, val timestamp: Long)

class CrewLeaderboardViewModel : ViewModel() {
    private val _scores = MutableStateFlow<List<CrewScore>>(emptyList())
    val scores: StateFlow<List<CrewScore>> = _scores

    private val db = FirebaseDatabase.getInstance()

    init {
        val scoresRef = db.getReference("crewScores")

        scoresRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<CrewScore>()
                for (crewSnap in snapshot.children) {
                    val crewId = crewSnap.key ?: continue
                    val data = crewSnap.value as? Map<*, *> ?: continue
                    val totalCoins = (data["totalCoins"] as? Long)?.toInt() ?: 0
                    val activeUsers = (data["activeUsers"] as? Long)?.toInt() ?: 0
                    val timestamp = (data["timestamp"] as? Long) ?: 0L

                    list.add(CrewScore(crewId, totalCoins, activeUsers, timestamp))
                }
                _scores.value = list.sortedByDescending { it.totalCoins }
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }
}

