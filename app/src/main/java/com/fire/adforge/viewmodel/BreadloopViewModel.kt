package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class BreadloopViewModel : ViewModel() {
    val livenessTriggered = MutableStateFlow(false)
    val showGratitudePopup = MutableStateFlow(false)
    val showBonusTicketPopup = MutableStateFlow(false)
    val raffleId = MutableStateFlow("23JS8361")

    val sessionCoins = MutableStateFlow(0)
    val walletCoins = MutableStateFlow(0)
    val isSessionEligible = MutableStateFlow(false)

    val currentPlaybackTime = MutableStateFlow(0L) // in milliseconds
    val selectedLivenessTime = MutableStateFlow(120000L) // default: 2 min

    fun updatePlaybackTime(ms: Long) {
        currentPlaybackTime.value = ms
        if (!livenessTriggered.value && ms >= selectedLivenessTime.value) {
            triggerLivenessMoment()
        }
    }

    fun triggerLivenessMoment() {
        livenessTriggered.value = true
        showGratitudePopup.value = true
    }

    fun onClaimAmoeTicket() {
        isSessionEligible.value = true
        showGratitudePopup.value = false
        showBonusTicketPopup.value = true
    }

    fun completeBonusTicketFlow() {
        showBonusTicketPopup.value = false
    }
}
