package com.fire.adforge.model

data class CrewLeaderboard(
    val crewName: String = "",
    val totalEarnings: Int = 0,
    val memberCount: Int = 0,
    val multiplier: Double = 1.0,
    val rank: Int = 0
)
