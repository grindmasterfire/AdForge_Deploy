package com.fire.adforge.viewmodel

import java.text.SimpleDateFormat
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

fun getRafflePoolIdByTime(): String {
    return when (selectedLivenessTime.value) {
        in 120_000L..136_000L -> "pool_a"
        in 136_001L..169_000L -> "pool_b"
        in 169_001L..219_000L -> "pool_c"
        in 219_001L..299_000L -> "pool_d"
        else -> "pool_e"
    }
}

fun getPoolRaffleId(poolId: String): String {
    val dateTag = SimpleDateFormat("MMdd", Locale.getDefault()).format(Date())
    return when (poolId) {
        "pool_a" -> "raffleA_$dateTag"
        "pool_b" -> "raffleB_$dateTag"
        "pool_c" -> "raffleC_$dateTag"
        "pool_d" -> "raffleD_$dateTag"
        "pool_e" -> "raffleE_$dateTag"
        else -> "raffleX_$dateTag"
    }
}

fun getAdCountForSession(): Int {
    return when (selectedLivenessTime.value) {
        in 120_000L..136_000L -> 3   // Pool A: 2:002:16
        in 136_001L..169_000L -> 4   // Pool B
        in 169_001L..219_000L -> 5   // Pool C
        in 219_001L..299_000L -> 6   // Pool D
        else -> 8                    // Pool E: 5:007:00
    }
}

var amoeTicketsEarned = mutableStateOf(0)
    private set

fun incrementAmoeTicketCount() {
    amoeTicketsEarned.value++
}
