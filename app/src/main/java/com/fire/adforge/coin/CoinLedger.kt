import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.coin

object CoinLedger {
    private var coinBalance = 0
    private val transactionHistory = mutableListOf<String>()

    fun getBalance(): Int = coinBalance

    fun addCoins(amount: Int, source: String) {
        coinBalance += amount
        transactionHistory.add("Earned $amount from $source")
    }

    fun spendCoins(amount: Int, reason: String): Boolean {
        return if (coinBalance >= amount) {
            coinBalance -= amount
            transactionHistory.add("Spent $amount on $reason")
            true
        } else {
            transactionHistory.add("Failed spend attempt: $amount on $reason")
            false
        }
    }

    fun getHistory(): List<String> = transactionHistory.toList()
}

