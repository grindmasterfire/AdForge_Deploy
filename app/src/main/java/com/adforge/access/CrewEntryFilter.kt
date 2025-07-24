package com.adforge.access

import com.adforge.crew.CrewManager

object CrewEntryFilter {
    fun canAccessCrewRaffle(userId: String, crewId: String): Boolean {
        return CrewManager.getCrewOf(userId) == crewId
    }
}
