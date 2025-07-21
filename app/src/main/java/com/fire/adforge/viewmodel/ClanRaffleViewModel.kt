package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ClanRaffleViewModel : ViewModel() {
    val selectedRaffleId = MutableStateFlow("")
    val entrySuccess = MutableStateFlow<Boolean?>(null)
    val resultWinner = MutableStateFlow<String?>(null)
}
