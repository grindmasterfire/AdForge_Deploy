import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.engine

object MilestoneEngine {
    fun calculateDiscountedCost(baseCost: Int, earnedOnly: Boolean): Int {
        return if (earnedOnly) {
            // Earned coins get 10% discount
            (baseCost * 0.9).toInt()
        } else {
            // No discount for bonus/referral coins
            baseCost
        }
    }
}

