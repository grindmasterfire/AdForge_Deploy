import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.social

data class Crew(
    val id: String,
    val name: String,
    val members: List<String>,
    val totalPoints: Int
)

