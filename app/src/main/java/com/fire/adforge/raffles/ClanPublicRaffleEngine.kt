import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.raffles

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import kotlin.random.Random

object ClanPublicRaffleEngine {
    private val db = FirebaseFirestore.getInstance()

    suspend fun runRaffle(clanId: String) {
        val entriesRef = db.collection("raffles")
            .document("clan_public")
            .collection(clanId)
            .document("entries")
            .collection("members")

        val snapshot = entriesRef.get().await()
        val entries = snapshot.documents.mapNotNull { doc ->
            val userId = doc.getString("userId") ?: return@mapNotNull null
            userId
        }

        if (entries.size < 3) return

        val prizePool = 10000
        val shuffled = entries.shuffled()

        val winners = shuffled.take(3)
        val consolationPool = shuffled.drop(3).shuffled().take(Random.nextInt(15, 26))

        val rewards = listOf(0.4, 0.2, 0.1)
        winners.forEachIndexed { i, userId ->
            val result = mapOf(
                "userId" to userId,
                "reward" to prizePool * rewards[i],
                "rank" to i + 1,
                "timestamp" to System.currentTimeMillis()
            )
            db.collection("raffles").document("clan_public")
                .collection(clanId).document("results")
                .collection("winners").document(userId).set(result)
        }

        val consolationShare = (prizePool * 0.25) / consolationPool.size
        consolationPool.forEach { userId ->
            val result = mapOf(
                "userId" to userId,
                "reward" to consolationShare,
                "rank" to 0,
                "timestamp" to System.currentTimeMillis()
            )
            db.collection("raffles").document("clan_public")
                .collection(clanId).document("results")
                .collection("consolation").document(userId).set(result)
        }
    }
}

