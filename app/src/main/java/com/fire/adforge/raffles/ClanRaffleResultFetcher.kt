package com.fire.adforge.raffles

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

data class ClanWinnerLog(
    val userId: String,
    val coins: Int,
    val raffleType: String,
    val timestamp: String
)

object ClanRaffleResultFetcher {
    suspend fun fetchWinners(clanId: String, raffleId: String): List<ClanWinnerLog> {
        val db = FirebaseFirestore.getInstance()
        val results = db.collection("clan_raffles")
            .document(clanId)
            .collection("raffles")
            .document(raffleId)
            .collection("winners")
            .get()
            .await()

        return results.documents.mapNotNull { doc ->
            val userId = doc.getString("userId")
            val coins = doc.getLong("coins")?.toInt() ?: 0
            val raffleType = doc.getString("raffleType") ?: "UNKNOWN"
            val timestamp = doc.getTimestamp("timestamp")?.toDate().toString()

            if (userId != null) ClanWinnerLog(userId, coins, raffleType, timestamp)
            else null
        }
    }
}
