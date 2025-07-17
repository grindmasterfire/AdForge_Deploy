import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.firebase

import com.fire.adforge.model.AuditLogEntry

object FirebaseSyncQueue {
    val pendingLogs = mutableListOf<AuditLogEntry>()

    fun enqueue(log: AuditLogEntry) {
        pendingLogs.add(log)
    }

    fun flushQueue(): List<AuditLogEntry> {
        val toSync = pendingLogs.toList()
        pendingLogs.clear()
        return toSync
    }

    fun isEmpty(): Boolean = pendingLogs.isEmpty()
}

