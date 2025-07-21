package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class WinnerData(
    val displayName: String,
    val raffleId: String,
    val amoeUsed: Boolean,
    val crewName: String? = null,
    val clanName: String? = null
)

class RaffleTickerViewModel : ViewModel() {
    private val _winners = MutableStateFlow<List<WinnerData>>(emptyList())
    val winners: StateFlow<List<WinnerData>> = _winners

    init {
        // TODO: Connect to Firestore streaming listener
        _winners.value = listOf(
            WinnerData("ZappyKat", "3821", true, "ShadowGrind", "Flameforge"),
            WinnerData("IronBear", "3820", false, "SteelCrew", null)
        )
    }
}
