package com.adforge.access

import com.adforge.clan.ClanRegistry
import com.adforge.crew.CrewManager

object ClanEntryFilter {
    fun canAccessClanRaffle(userId: String, clanId: String): Boolean {
        val userCrew = CrewManager.getCrewOf(userId) ?: return false
        return ClanRegistry.getClanCrews(clanId).contains(userCrew)
    }
}
