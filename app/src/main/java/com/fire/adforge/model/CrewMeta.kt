import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.model

data class CrewMeta(
    val name: String = "",
    val members: List<String> = emptyList(),
    val createdAt: Long = System.currentTimeMillis()
)

