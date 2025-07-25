package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fire.adforge.engine.RaffleAdminReseedEngine
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RaffleReseedViewModel : ViewModel() {
    val raffleId = MutableStateFlow("")
    val raffleType = MutableStateFlow("session") // can be session, daily, crew, clan, etc.
    val overrideCode = MutableStateFlow("")
    val statusMessage = MutableStateFlow("")

    fun reseed() {
        val path = when (raffleType.value) {
            "session", "daily", "weekly", "21day" -> "raffles"
            "crew" -> "crew_raffles"
            "clan" -> "clan_raffles"
            else -> "raffles"
        }

        if (overrideCode.value != "COMMAND-171") {
            statusMessage.value = "Invalid override code."
            return
        }

        viewModelScope.launch {
            val success = RaffleAdminReseedEngine.clearRaffleEntries(path, raffleId.value)
            statusMessage.value = if (success) "Raffle cleared." else "Raffle reset failed."
        }
    }
}
