package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fire.adforge.engine.MilestoneBoosterLedger
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BoosterInventoryViewModel : ViewModel() {
    val sponsorId = MutableStateFlow("")
    val userCoins = MutableStateFlow(0)
    val status = MutableStateFlow("")
    private val userId = "demoUser"

    fun setSponsor(id: String) {
        sponsorId.value = id
    }

    fun updateWallet(balance: Int) {
        userCoins.value = balance
    }

    fun activateBooster() {
        viewModelScope.launch {
            val success = MilestoneBoosterLedger.activateBooster(userId, sponsorId.value, 100)
            status.value = if (success) "Booster activated!" else "Insufficient coins."
        }
    }
}
