import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DailyRaffleViewModel : ViewModel() {
    private val _dailyTicketCount = MutableStateFlow(0)
    val dailyTicketCount: StateFlow<Int> = _dailyTicketCount

    fun refreshTickets() {
        _dailyTicketCount.value = (10..50).random()
    }

    fun purchaseTickets(amount: Int) {
        val current = _dailyTicketCount.value
        if (amount > 0 && amount <= current) {
            _dailyTicketCount.value = current - amount
            // Implement coin deduction and Firestore sync here later
        }
    }
}

    fun buyTickets(userId: String, tickets: Int) {
        // TODO: Implement coin deduction logic here
        enterRaffle(userId, tickets)
    }

    private val _dailyRaffleWinner = MutableStateFlow<Pair<String, Int>?>(null)
    val dailyRaffleWinner: StateFlow<Pair<String, Int>?> = _dailyRaffleWinner

    fun drawRaffle() {
        val entries = raffleEntries.value
        if (entries.isEmpty()) {
            _dailyRaffleWinner.value = null
            return
        }
        // Simple random winner selection weighted by tickets
val weightedList: List<String> = buildList {
    for ((user, tickets) in entries) {
        repeat(tickets) {
            add(user)
        }
    }
}
    repeat(tickets) {
        weightedList.add(user)
    }
}
        val winner = weightedList.random()
        val prize = 1000 // Placeholder prize amount
        _dailyRaffleWinner.value = winner to prize
        clearEntries()
    }

