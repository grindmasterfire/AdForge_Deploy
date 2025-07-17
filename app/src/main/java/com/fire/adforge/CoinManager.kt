import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge

import android.content.Context
import android.content.SharedPreferences

object CoinManager {
    private const val PREF_NAME = "coin_prefs"
    private const val KEY_COIN_BALANCE = "coin_balance"

    private lateinit var prefs: SharedPreferences

    fun init(context: Context) {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    fun getBalance(): Int = prefs.getInt(KEY_COIN_BALANCE, 0)

    fun addCoins(amount: Int) {
        val newBalance = getBalance() + amount
        prefs.edit().putInt(KEY_COIN_BALANCE, newBalance).apply()
    }

    fun spendCoins(amount: Int): Boolean {
        val current = getBalance()
        return if (current >= amount) {
            prefs.edit().putInt(KEY_COIN_BALANCE, current - amount).apply()
            true
        } else false
    }
}

