import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.models

data class BotProfile(
    val name: String,
    val role: String,
    val avatar: String,
    val messages: Map<String, String>
)

