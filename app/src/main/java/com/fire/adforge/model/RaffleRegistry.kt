import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.model

import androidx.compose.runtime.mutableStateListOf

data class RaffleTemplate(
    val id: String,
    val name: String,
    val entryCost: Int,
    val isLive: Boolean
)

object RaffleRegistry {
    val raffles = mutableStateListOf(
        RaffleTemplate("daily", "Daily Draw", 5, true),
        RaffleTemplate("weekly", "7-Day Pool", 15, true),
        RaffleTemplate("jackpot", "21-Day Jackpot", 25, false)
    )

    fun createEmptyTemplate(): RaffleTemplate {
        val newId = "raffle_" + System.currentTimeMillis().toString()
        val template = RaffleTemplate(
            id = newId,
            name = "Untitled Raffle",
            entryCost = 0,
            isLive = false
        )
        raffles.add(template)`r`n        RaffleAudit.log("CREATE", newId)
        return template
    }
}

