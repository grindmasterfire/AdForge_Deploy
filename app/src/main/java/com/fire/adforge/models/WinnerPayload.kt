import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.models

data class WinnerPayload(
    val userId: String,
    val percentOfPot: Double,
    val payoutCoins: Long
)

