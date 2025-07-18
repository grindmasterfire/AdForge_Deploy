package com.fire.adforge.model

data class CrewMeta(
    val crewName: String = "",
    val founderUid: String = "",
    val createdAt: Long = System.currentTimeMillis(),
    val members: List<String> = listOf(),
    val multiplier: Double = 1.0
)
