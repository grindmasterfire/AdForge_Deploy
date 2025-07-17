import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.breadloop

import kotlinx.coroutines.*
import com.google.firebase.firestore.FirebaseFirestore
import java.time.Instant
import kotlin.random.Random

data class RaffleEntryPayload(
    val userId: String,
    val sessionId: String,
    val poolId: String,
    val timestamp: Long,
    val usedCoins: Int,
    val isAmoe: Boolean
)

object BreadloopEngine {
    private val firestore = FirebaseFirestore.getInstance()
    private val sessionScope = CoroutineScope(Dispatchers.Default)

    // ?? Configurable slider (user preference)
    var userIntervalMillis: Long = 180000 // Default to 3:00

    fun start(sessionId: String, userId: String) {
        sessionScope.launch {
            while (true) {
                delay(userIntervalMillis)
                launchRaffleBubble(userId, sessionId)
            }
        }
    }

    private fun launchRaffleBubble(userId: String, sessionId: String) {
        val timestamp = Instant.now().epochSecond
        val poolId = getRafflePoolForTime(timestamp)

        // ? Show Codex-defined bubble (UI handles actual display)
        val bubbleText = \"
        The sponsors would like to thank you for watching their ads and hope they provide you with good choices.
        Would you like to spend some of your earnings to enter this limited-time raffle pool with all the other users for a grand prize?
        \".trimIndent()

        // ? Automatically grant 1 AMOE ticket
        val amoeEntry = RaffleEntryPayload(
            userId = userId,
            sessionId = sessionId,
            poolId = poolId,
            timestamp = timestamp,
            usedCoins = 0,
            isAmoe = true
        )
        submitRaffleEntry(amoeEntry)
    }

    private fun getRafflePoolForTime(epochSec: Long): String {
        val minuteBlock = (epochSec % 3600) / 30  // 30-second segments
        return "POOL_"
    }

    fun submitRaffleEntry(entry: RaffleEntryPayload) {
        val ref = firestore.collection("raffle_entries")
            .document("\_\_\")
        ref.set(entry)
    }

    fun submitPurchasedTickets(userId: String, sessionId: String, poolId: String, ticketCount: Int, coinsSpent: Int) {
        val timestamp = Instant.now().epochSecond
        repeat(ticketCount.coerceAtMost(10)) {
            val entry = RaffleEntryPayload(
                userId = userId,
                sessionId = sessionId,
                poolId = poolId,
                timestamp = timestamp + it,
                usedCoins = coinsSpent / ticketCount,
                isAmoe = false
            )
            submitRaffleEntry(entry)
        }
    }
}

