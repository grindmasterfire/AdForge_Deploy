package com.fire.adforge.crew

object CrewPublicRaffleContest {
    fun rankCrewsByGrind(crews: Map<String, Int>): List<String> {
        return crews.entries.sortedByDescending { it.value }.map { it.key }
    }

    fun distributePrizes(crews: List<String>, prizePool: Int): Map<String, Int> {
        val prizes = listOf(0.5, 0.3, 0.2)
        return crews.take(3).mapIndexed { index, crewId ->
            crewId to (prizePool * prizes.getOrElse(index) { 0.0 }).toInt()
        }.toMap()
    }
}
