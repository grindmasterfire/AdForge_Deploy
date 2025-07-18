package com.fire.adforge.model

data class BoosterOffer(
    val offerId: String = "",
    val title: String = "",
    val provider: String = "",
    val coinCost: Int = 0,
    val boostPercent: Int = 5,
    val timestamp: Long = System.currentTimeMillis()
)
