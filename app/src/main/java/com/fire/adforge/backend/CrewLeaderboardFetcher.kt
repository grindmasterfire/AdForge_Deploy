package com.fire.adforge.backend

import com.fire.adforge.model.CrewLeaderboard
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

object CrewLeaderboardFetcher {

    private val db = FirebaseFirestore.getInstance()

    suspend fun getLeaderboard(): List<CrewLeaderboard> {
        val crews = db.collection("crews").get().await()
        val board = crews.documents.mapIndexed { index, doc ->
            val crewName = doc.id
            val members = (doc["members"] as? List<*>) ?: emptyList<Any>()
            val multiplier = doc.getDouble("multiplier") ?: 1.0
            val totalEarnings = members.size * 100  // Placeholder logic

            CrewLeaderboard(
                crewName = crewName,
                totalEarnings = totalEarnings,
                memberCount = members.size,
                multiplier = multiplier,
                rank = index + 1
            )
        }.sortedByDescending { it.totalEarnings }

        return board.mapIndexed { i, entry -> entry.copy(rank = i + 1) }
    }
}
