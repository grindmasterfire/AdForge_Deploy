import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.util

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object ClanRaffleManager {
    private val entries = mutableMapOf<String, Int>() // key: userId, value: ticket count
    private val _entryLog = MutableStateFlow<Map<String, Int>>(emptyMap())
    val entryLog: StateFlow<Map<String, Int>> = _entryLog

    fun enterRaffle(userId: String, ticketCount: Int): Boolean {
        val existing = entries[userId] ?: 0
        entries[userId] = existing + ticketCount
        _entryLog.value = entries.toMap()
        return true
    }

    fun getUserTickets(userId: String): Int {
        return entries[userId] ?: 0
    }

    fun resetClanEntries() {
        entries.clear()
        _entryLog.value = emptyMap()
    }

    fun allEntries(): Map<String, Int> {
        return entries.toMap()
    }

    // For diagnostics or testing
    fun preloadTestData() {
        entries["alpha123"] = 5
        entries["bravo456"] = 2
        entries["charlie789"] = 1
        _entryLog.value = entries.toMap()
    }
}

