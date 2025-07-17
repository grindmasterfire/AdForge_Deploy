import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.model

data class AuditLogEntry(
    val action: String,
    val raffleId: String,
    val timestamp: Long
)

object RaffleAudit {
    val logs = mutableListOf<AuditLogEntry>()

    fun log(action: String, raffleId: String) {
        val log = 
            AuditLogEntry(
                action = action,
                raffleId = raffleId,
                timestamp = System.currentTimeMillis()
            )
        )
    }
}

