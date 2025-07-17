import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.model

data class UserAccount(
    val userId: String = "",
    val referrerChain: List<String> = emptyList(), // Stores up to 4 tiers
    val referralEarnings: Map<String, Int> = emptyMap() // userId → total earned from them
)

