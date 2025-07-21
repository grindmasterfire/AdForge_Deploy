package com.fire.adforge.model

data class Referral(
    val userId: String = "",
    val referredBy: String? = null,
    val tier1: List<String> = listOf(),
    val tier2: List<String> = listOf(),
    val tier3: List<String> = listOf(),
    val tier4: List<String> = listOf()
)
