package com.adforge.clan

import com.adforge.crew.CrewManager

object ClanRegistry {
    private val clans = mutableMapOf<String, Clan>()

    fun addCrewToClan(clanId: String, crewId: String) {
        val clan = clans.getOrPut(clanId) { Clan(clanId) }
        clan.crewIds.add(crewId)
    }

    fun removeCrewFromClan(clanId: String, crewId: String) {
        clans[clanId]?.crewIds?.remove(crewId)
        if ((clans[clanId]?.crewIds?.size ?: 0) < 4) {
            clans.remove(clanId) // Auto disband if <4 crews
        }
    }

    fun getClanCrews(clanId: String): Set<String> {
        return clans[clanId]?.crewIds ?: emptySet()
    }

    fun isClanValid(clanId: String): Boolean {
        return (clans[clanId]?.crewIds?.size ?: 0) >= 5
    }

    fun all(): List<Clan> = clans.values.toList()
}
