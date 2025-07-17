import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.raffle

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

data class RaffleParticipant(
    val userId: String = "",
    val ticketCount: Int = 1,
    val coinsEarned: Int = 0
)

object ResultEngine {

    private val db = FirebaseFirestore.getInstance()

    suspend fun resolveTieredRaffle(poolId: String, totalPot: Int) {
        try {
            val entriesRef = db.collection("raffle_entries")
                .whereEqualTo("poolId", poolId).get().await()

            val entries = entriesRef.documents.mapNotNull { it.toObject(RaffleParticipant::class.java) }
            if (entries.size < 3) return

            val shuffled = entries.shuffled()
            val winners = shuffled.take(3)
            val consolation = shuffled.drop(3)

            val first = winners[0].userId
            val second = winners[1].userId
            val third = winners[2].userId

            val dist = mapOf(
                first to (totalPot * 0.33).toInt(),
                second to (totalPot * 0.22).toInt(),
                third to (totalPot * 0.15).toInt()
            )

            dist.forEach { (userId, coins) ->
                db.collection("raffle_winners").add(
                    mapOf(
                        "userId" to userId,
                        "coins_awarded" to coins,
                        "poolId" to poolId,
                        "timestamp" to System.currentTimeMillis()
                    )
                ).await()
            }

            val remaining = totalPot - dist.values.sum()
            val consolationPot = remaining / consolation.size

            consolation.forEach {
                db.collection("raffle_consolation").add(
                    mapOf(
                        "userId" to it.userId,
                        "coins_awarded" to consolationPot,
                        "poolId" to poolId,
                        "timestamp" to System.currentTimeMillis()
                    )
                ).await()
            }

        } catch (e: Exception) {
            Log.e("ResultEngine", "Failed to resolve raffle", e)
        }
    }
}

