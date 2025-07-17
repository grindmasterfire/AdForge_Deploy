import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.raffle

import com.fire.adforge.rewards.RewardLedger
import com.fire.adforge.state.UserState
import kotlin.random.Random

object RaffleDrawEngine {

    fun drawWinner(tickets: List<RaffleTicket>, userId: String): String? {
        if (tickets.isEmpty()) return null

        val winner = tickets.random().userId
        if (winner == userId) {
            val rewardAmount = Random.nextInt(5, 15)
            RewardLedger.logReward(userId, rewardAmount, "Raffle Victory")
        }

        return winner
    }
}

