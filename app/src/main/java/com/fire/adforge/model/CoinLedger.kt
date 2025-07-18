package com.fire.adforge.model

data class CoinLedger(
    val userId: String = "",
    val timestamp: Long = System.currentTimeMillis(),
    val type: String = "", // e.g., \"earn\", \"spend\", \"boost\"
    val amount: Int = 0,
    val source: String = "" // e.g., \"surveywall\", \"watchad\", \"referral\"
)
