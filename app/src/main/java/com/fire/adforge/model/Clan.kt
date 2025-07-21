package com.fire.adforge.model

data class Clan(
    val clanId: String = "",
    val clanName: String = "",
    val crewIds: List<String> = listOf(),
    val createdAt: Long = System.currentTimeMillis()
)
