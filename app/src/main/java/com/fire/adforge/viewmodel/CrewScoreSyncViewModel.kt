import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.database.*
import java.util.*

class CrewScoreSyncViewModel : ViewModel() {

    private val db = FirebaseDatabase.getInstance()
    private val userIds = listOf("userA", "userB", "userC") // Replace with real user logic

    fun syncCrewScores() {
        val crewMap = mutableMapOf<String, MutableList<Pair<String, Int>>>()

        for (userId in userIds) {
            val crewRef = db.getReference("userMeta/\/crew")
            val coinsRef = db.getReference("userEarnings/\/coinTotal")

            crewRef.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(crewSnap: DataSnapshot) {
                    val crewId = crewSnap.getValue(String::class.java) ?: return

                    coinsRef.addListenerForSingleValueEvent(object : ValueEventListener {
                        override fun onDataChange(coinsSnap: DataSnapshot) {
                            val coins = coinsSnap.getValue(Int::class.java) ?: 0
                            crewMap.getOrPut(crewId) { mutableListOf() }.add(userId to coins)

                            if (crewMap.values.sumOf { it.size } == userIds.size) {
                                finalizeScores(crewMap)
                            }
                        }

                        override fun onCancelled(error: DatabaseError) {}
                    })
                }

                override fun onCancelled(error: DatabaseError) {}
            })
        }
    }

    private fun finalizeScores(map: Map<String, List<Pair<String, Int>>>) {
        for ((crewId, members) in map) {
            val total = members.sumOf { it.second }
            val active = members.count()
            val timestamp = Date().time

            val payload = mapOf(
                "totalCoins" to total,
                "activeUsers" to active,
                "timestamp" to timestamp
            )

            db.getReference("crewScores/\").setValue(payload)
        }
    }
}

