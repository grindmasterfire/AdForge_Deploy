import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.engine

import android.content.Context
import android.content.SharedPreferences

object CoinManager {
    private lateinit var prefs: SharedPreferences

    fun init(context: Context) {
        prefs = context.getSharedPreferences("adforge_prefs", Context.MODE_PRIVATE)
    }

    fun getBalance(): Int {
        return prefs.getInt("coin_balance", 0)
    }

    fun addCoins(amount: Int) {
        val newBalance = getBalance() + amount
        prefs.edit().putInt("coin_balance", newBalance).apply()
    }

    fun spendCoins(amount: Int): Boolean {
        val current = getBalance()
        return if (current >= amount) {
            prefs.edit().putInt("coin_balance", current - amount).apply()
            true
        } else {
            false
        }
    }

    fun reset() {
        prefs.edit().putInt("coin_balance", 0).apply()
    }
}

