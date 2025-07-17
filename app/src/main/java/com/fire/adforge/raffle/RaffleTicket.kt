import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.raffle

data class RaffleTicket(
    val ticketId: String,
    val ownerId: String,
    val sessionId: String,
    val timestamp: Long
)

