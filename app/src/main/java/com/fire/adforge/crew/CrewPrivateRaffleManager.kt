package com.fire.adforge.crew

object CrewPrivateRaffleManager {
    fun selectTopContributors(contributors: Map<String, Int>): List<String> {
        val sorted = contributors.entries.sortedByDescending { it.value }
        val topN = sorted.take(3)
        return topN.map { it.key }
    }
}
