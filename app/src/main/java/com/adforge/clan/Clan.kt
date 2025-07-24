package com.adforge.clan

data class Clan(
    val clanId: String,
    val crewIds: MutableSet<String> = mutableSetOf()
)
