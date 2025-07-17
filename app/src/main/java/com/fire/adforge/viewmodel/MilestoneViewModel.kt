import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MilestoneViewModel : ViewModel() {
    private val _spentCoins = MutableStateFlow(0)
    val spentCoins: StateFlow<Int> = _spentCoins

    fun spendCoins(amount: Int): Boolean {
        if (amount <= 0) return false
        // Add validation and coin deduction logic here
        _spentCoins.value += amount
        return true
    }

    fun getDiscount(): Double {
        val spent = _spentCoins.value
        return when {
            spent >= 1000 -> 0.10
            spent >= 500 -> 0.07
            spent >= 100 -> 0.05
            else -> 0.0
        }
    }
}

