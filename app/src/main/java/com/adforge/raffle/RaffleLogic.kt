package com.adforge.raffle

class RaffleLogic {
    fun getRewardStrategy(type: RaffleType): String {
        return when (type) {
            RaffleType.WINNER_TAKES_ALL -> "100% to winner"
            RaffleType.TIERED_PLUS_40_SPLIT -> "1/3 to top 3, 2/3 to 40% of players"
            RaffleType.SIXTY_PERCENT_CONSOLATION -> "60% of entries win equal coins"
        }
    }
}
