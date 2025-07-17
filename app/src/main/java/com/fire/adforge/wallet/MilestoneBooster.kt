package com.fire.adforge.wallet

object MilestoneBooster {
    fun calculateDiscountedPrice(original: Int, earnedOnly: Boolean): Int {
        if (!earnedOnly) return original
        val discountRate = 0.10 // 10% off earned-only purchases
        val discounted = (original * (1 - discountRate)).toInt()
        return if (discounted < original) discounted else original
    }
}
