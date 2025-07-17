import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.economy

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object CoinManager {

    private val _coinBalance = MutableStateFlow(0)
    val coinBalance: StateFlow<Int> = _coinBalance

    private var crewMultiplier: Double = 1.0

    fun addCoins(amount: Int) {
        val bonus = (amount * crewMultiplier).toInt()
        _coinBalance.value += bonus
    }

    fun subtractCoins(amount: Int) {
        _coinBalance.value = (_coinBalance.value - amount).coerceAtLeast(0)
    }

    fun setMultiplier(multiplier: Double) {
        crewMultiplier = multiplier.coerceAtLeast(1.0)
    }

    fun reset() {
        _coinBalance.value = 0
        crewMultiplier = 1.0
    }
}

