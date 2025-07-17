import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ClanRaffleViewModel : ViewModel() {
    private val _clanTicketMap = MutableStateFlow(mapOf<String, Int>())
    val clanTicketMap: StateFlow<Map<String, Int>> = _clanTicketMap

    private val _coinWeightMap = MutableStateFlow(mapOf<String, Int>())
    val coinWeightMap: StateFlow<Map<String, Int>> = _coinWeightMap

    fun syncClanStatus() {
        _clanTicketMap.value = mapOf(
            "Clan Alpha" to 42,
            "Clan Beta" to 28,
            "Clan Gamma" to 77
        )
        _coinWeightMap.value = mapOf(
            "Clan Alpha" to 1050,
            "Clan Beta" to 650,
            "Clan Gamma" to 2400
        )
    }

    fun simulateBoost(clanId: String, coinsBurned: Int) {
        val current = _coinWeightMap.value.toMutableMap()
        val updated = current.getOrDefault(clanId, 0) + coinsBurned
        current[clanId] = updated
        _coinWeightMap.value = current
    }
}

