import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.engine

object MilestoneSpendEngine {

    fun calculateDiscountedCost(originalCost: Long, discountPercent: Int): Long {
        val discount = (originalCost * discountPercent) / 100
        return originalCost - discount
    }

    fun validateSpend(userCoins: Long, cost: Long): Boolean {
        return userCoins >= cost
    }

    fun processSpend(originalCost: Long, userCoins: Long, discountPercent: Int): Pair<Long, Long> {
        val finalCost = calculateDiscountedCost(originalCost, discountPercent)
        return if (validateSpend(userCoins, finalCost)) {
            val remaining = userCoins - finalCost
            Pair(finalCost, remaining)
        } else {
            Pair(0L, userCoins)
        }
    }
}

