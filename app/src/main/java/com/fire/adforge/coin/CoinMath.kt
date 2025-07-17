import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.coin

object CoinMath {
    fun calculateSurveyEarnings(difficulty: String): Int {
        return when (difficulty) {
            "easy" -> 10
            "medium" -> 25
            "hard" -> 50
            else -> 0
        }
    }

    fun applyReferralBonus(base: Int, tier: Int): Int {
        val multiplier = when (tier) {
            1 -> 1.10
            2 -> 1.05
            3 -> 1.03
            4 -> 1.01
            else -> 1.0
        }
        return (base * multiplier).toInt()
    }
}

