package com.fire.adforge.raffle

object TieredRaffleSplitter {
    data class RaffleResult(
        val first: String,
        val second: String,
        val third: String,
        val consolationWinners: List<String>,
        val prizeDistribution: Map<String, Int>
    )

    fun split(prizePool: Int, entrants: List<String>): RaffleResult {
        val shuffled = entrants.shuffled()
        val top = shuffled.take(3)
        val consolation = shuffled.drop(3).shuffled().take((entrants.size * 0.4).toInt())
        val distribution = mutableMapOf<String, Int>()

        // Top 3 split 1/3
        val topShare = prizePool / 3
        val splitTop = listOf(0.5, 0.3, 0.2)
        top.forEachIndexed { i, id -> distribution[id] = (topShare * splitTop[i]).toInt() }

        // Remaining 2/3 goes to 40% of remaining
        val remainingPool = prizePool - distribution.values.sum()
        consolation.forEach { id ->
            distribution[id] = remainingPool / consolation.size
        }

        return RaffleResult(
            first = top.getOrNull(0) ?: "",
            second = top.getOrNull(1) ?: "",
            third = top.getOrNull(2) ?: "",
            consolationWinners = consolation,
            prizeDistribution = distribution
        )
    }
}
