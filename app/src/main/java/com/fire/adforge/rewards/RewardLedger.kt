import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.rewards

data class RewardLedger(
    val userId: String,
    val coinsBefore: Int,
    val coinsAfter: Int,
    val reason: String,
    val timestamp: Long
)

