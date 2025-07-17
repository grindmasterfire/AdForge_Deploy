import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.model

data class RaffleState(
    val raffleName: String,
    val isLive: Boolean,
    val ticketCount: Int,
    val entryCost: Int // in coins
)

