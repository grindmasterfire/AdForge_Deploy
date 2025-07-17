import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.raffle

data class CrewRaffleResult(
    val winnerIds: List<String>,
    val scores: Map<String, Int>
)

object CrewRaffleManager {

    fun resolvePrivateRaffle(scores: Map<String, Int>): CrewRaffleResult {
        val sorted = scores.entries.sortedByDescending { it.value }
        val top = sorted.take(3).map { it.key }
        return CrewRaffleResult(winnerIds = top, scores = scores)
    }

    fun resolvePublicRaffle(crewScores: Map<String, Int>): CrewRaffleResult {
        val sorted = crewScores.entries.sortedByDescending { it.value }
        val topCrews = sorted.take(2).map { it.key }
        return CrewRaffleResult(winnerIds = topCrews, scores = crewScores)
    }
}

