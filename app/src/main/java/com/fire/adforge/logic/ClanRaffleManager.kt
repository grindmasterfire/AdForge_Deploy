import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.logic

data class ClanMember(val userId: String, val activityScore: Int)

data class ClanRaffleResult(
    val winners: List<String>,
    val consolationWinners: List<String>
)

object ClanRaffleManager {
    fun runRaffle(clanId: String, participants: List<ClanMember>): ClanRaffleResult {
        if (participants.size < 3) return ClanRaffleResult(emptyList(), emptyList())

        val sorted = participants.sortedByDescending { it.activityScore }
        val winners = sorted.take(3).map { it.userId }

        val remaining = sorted.drop(3)
        val consolationCount = (remaining.size * 0.4).toInt().coerceAtLeast(1)
        val consolationWinners = remaining.shuffled().take(consolationCount).map { it.userId }

        return ClanRaffleResult(winners, consolationWinners)
    }
}

