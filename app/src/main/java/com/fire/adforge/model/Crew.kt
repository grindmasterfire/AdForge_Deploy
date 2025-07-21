package com.fire.adforge.model

data class Crew(
    val crewId: String = "",
    val crewName: String = "",
    val members: List<String> = listOf(),
    val leaderId: String = "",
    val totalGrind: Int = 0,
    val createdAt: Long = System.currentTimeMillis()
)
