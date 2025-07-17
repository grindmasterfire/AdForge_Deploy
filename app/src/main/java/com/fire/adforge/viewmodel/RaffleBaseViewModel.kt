import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

open class RaffleBaseViewModel : ViewModel() {
    protected val _raffleEntries = MutableStateFlow<Map<String, Int>>(emptyMap())
    val raffleEntries: StateFlow<Map<String, Int>> = _raffleEntries

    fun enterRaffle(userId: String, tickets: Int) {
        val current = _raffleEntries.value.toMutableMap()
        val currentTickets = current.getOrDefault(userId, 0)
        current[userId] = currentTickets + tickets
        _raffleEntries.value = current
    }

    fun clearEntries() {
        _raffleEntries.value = emptyMap()
    }
}

