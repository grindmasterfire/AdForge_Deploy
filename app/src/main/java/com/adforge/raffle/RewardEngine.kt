package com.adforge.raffle

class RewardEngine {

    fun calculateRewards(type: RaffleType, totalPot: Int, entrants: Int): String {
        return when (type) {
            RaffleType.WINNER_TAKES_ALL ->
                "1 winner gets totalPot coins."

            RaffleType.TIERED_PLUS_40_SPLIT -> {
                val top = totalPot / 3
                val rest = totalPot - top
                val splitAmong = (entrants * 0.4).toInt()
                "Top 3 split top; rest split among splitAmong others."
            }

            RaffleType.SIXTY_PERCENT_CONSOLATION -> {
                val payout = totalPot / (entrants * 0.6).toInt()
                "payout coins to each of 60% of entrants."
            }
        }
    }
}
