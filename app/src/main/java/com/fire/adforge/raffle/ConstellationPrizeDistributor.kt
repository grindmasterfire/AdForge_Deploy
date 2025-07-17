package com.fire.adforge.raffle

object ConstellationPrizeDistributor {
    fun distribute(pool: Int, entrants: List<String>): Map<String, Int> {
        val eligible = entrants.shuffled().take((entrants.size * 0.4).toInt())
        val eachShare = if (eligible.isNotEmpty()) pool / eligible.size else 0
        return eligible.associateWith { eachShare }
    }
}
