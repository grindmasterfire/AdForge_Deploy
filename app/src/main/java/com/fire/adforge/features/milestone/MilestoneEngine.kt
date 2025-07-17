import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.features.milestone

import com.fire.adforge.data.User
import com.fire.adforge.data.CoinWallet
import com.fire.adforge.models.MilestoneBooster

object MilestoneEngine {

    fun purchaseBooster(user: User, booster: MilestoneBooster): Boolean {
        if (!booster.coinEligible || !user.wallet.isEarnedOnly(booster.price)) return false

        val discountRate = booster.discountRate ?: 0.05
        val discountedPrice = (booster.price * (1 - discountRate)).toInt()

        return if (user.wallet.spendEarnedCoins(discountedPrice)) {
            booster.unlockFor(user)
            true
        } else {
            false
        }
    }
}

