package com.fire.adforge.viewmodel

class BoosterEngine {

    fun applyBooster(originalCost: Int, discountPercent: Int): Int {
        if (discountPercent < 5 || discountPercent > 10) return originalCost
        val discount = originalCost * discountPercent / 100
        return originalCost - discount
    }

    fun isEligibleForBooster(source: String): Boolean {
        return source == "earned"
    }
}
