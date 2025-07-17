import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.model

data class RaffleMeta(
    val id: String = "",
    val name: String = "",
    val type: String = "daily", // daily, 7-day, 21-day
    val endsAt: Long = 0L,
    val entryCap: Int = 100,
    val entries: Int = 0
)

