package com.adforge.crew

object CrewRewardSystem {
    private val contributions = mutableMapOf<String, MutableMap<String, Int>>() // crewId -> (userId -> score)

    fun logContribution(userId: String, crewId: String, points: Int) {
        val crewLog = contributions.getOrPut(crewId) { mutableMapOf() }
        crewLog[userId] = (crewLog[userId] ?: 0) + points
    }

    fun getTopContributors(crewId: String, top: Int = 3): List<Pair<String, Int>> {
        return contributions[crewId]
            ?.toList()
            ?.sortedByDescending { it.second }
            ?.take(top)
            ?: emptyList()
    }

    fun resetContributions(crewId: String) {
        contributions[crewId]?.clear()
    }

    fun clearAll() {
        contributions.clear()
    }

    fun all(): Map<String, Map<String, Int>> = contributions
}
