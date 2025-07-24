package com.adforge.crew

object CrewManager {
    private val crews = mutableMapOf<String, Crew>()

    fun joinCrew(userId: String, crewId: String) {
        val crew = crews.getOrPut(crewId) { Crew(crewId) }
        crew.members.add(userId)
    }

    fun leaveCrew(userId: String, crewId: String) {
        crews[crewId]?.members?.remove(userId)
    }

    fun getCrewOf(userId: String): String? {
        return crews.entries.find { it.value.members.contains(userId) }?.key
    }

    fun getCrewMembers(crewId: String): Set<String> {
        return crews[crewId]?.members ?: emptySet()
    }

    fun getActiveCrews(): List<Crew> {
        return crews.values.filter { it.members.isNotEmpty() }
    }
}
