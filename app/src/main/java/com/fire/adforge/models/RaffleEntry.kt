import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.models

import com.google.firebase.Timestamp

data class RaffleEntry(
    val raffleId: String = "",
    val type: String = "daily",            // daily, 7day, 21day_jackpot, 21day_split
    val prize: Long = 0,
    val ticketCap: Int? = null,
    val created: Timestamp = Timestamp.now(),
    val endsAt: Timestamp = Timestamp.now(),
    val scope: String = "global",          // global, crew, clan
    val clanId: String? = null
)

