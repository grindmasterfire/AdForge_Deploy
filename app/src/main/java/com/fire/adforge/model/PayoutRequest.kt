import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.model

data class PayoutRequest(
    val userId: String = "",
    val method: String = "",
    val amount: Int = 0,
    val timestamp: Long = System.currentTimeMillis(),
    val status: String = "pending"
)

