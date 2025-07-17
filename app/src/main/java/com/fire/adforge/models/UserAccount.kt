import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.models

data class UserAccount(
    val userId: String,
    val username: String,
    val coins: Long,
    val referralCode: String,
    val crewId: String? = null,
    val isAdult: Boolean = false
)

