import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.raffles

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import kotlin.random.Random

object ClanPrivateRaffleEngine {
    private val db = FirebaseFirestore.getInstance()

    suspend fun runRaffle(clanId: String) {
        val entriesRef = db.collection("raffles")
            .document("clan_private")
            .collection(clanId)
            .document("entries")
            .collection("members")

        val snapshot = entriesRef.get().await()
        val entries = snapshot.documents.mapNotNull { doc ->
            val coins = doc.getLong("earnedCoins") ?: 0
            val userId = doc.getString("userId") ?: return@mapNotNull null
            userId to coins
        }.sortedByDescending { it.second }

        val top10 = entries.take(10)
        if (top10.isEmpty()) return

        val prizePool = 10000
        val winnerCount = minOf(3, top10.size)

        val winners = top10.shuffled().take(winnerCount)

        winners.forEachIndexed { index, (userId, _) ->
            val reward = when (index) {
                0 -> prizePool * 0.5
                1 -> prizePool * 0.3
                2 -> prizePool * 0.2
                else -> 0.0
            }

            val result = mapOf(
                "userId" to userId,
                "reward" to reward,
                "timestamp" to System.currentTimeMillis()
            )

            db.collection("raffles")
                .document("clan_private")
                .collection(clanId)
                .document("results")
                .collection("winners")
                .document(userId)
                .set(result)
        }
    }
}

