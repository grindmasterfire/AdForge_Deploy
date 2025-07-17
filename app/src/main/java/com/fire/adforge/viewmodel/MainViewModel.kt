package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class Badge(val id: String, val name: String)

class MainViewModel : ViewModel() {
    val badges = listOf(
        Badge("1", "Loyalty"),
        Badge("2", "Referral"),
        Badge("3", "Grind Master")
    )

    private val _unlockedTimestamps = MutableStateFlow<Map<String, Long>>(emptyMap())
    val unlockedTimestamps: StateFlow<Map<String, Long>> = _unlockedTimestamps

    init {
        // Static test data
        _unlockedTimestamps.value = mapOf(
            "1" to System.currentTimeMillis() - 86400000,
            "2" to System.currentTimeMillis() - 43200000
        )
    }
}
