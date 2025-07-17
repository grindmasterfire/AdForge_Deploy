import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.model

data class RaffleTemplate(
    val id: String,
    val name: String,
    val entryCost: Int,
    val isLive: Boolean
)

