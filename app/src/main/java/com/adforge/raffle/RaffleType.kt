package com.adforge.raffle

enum class RaffleType(val description: String) {
    WINNER_TAKES_ALL("One winner receives 100% of the pot."),
    TIERED_PLUS_40_SPLIT("1st, 2nd, 3rd win 1/3 of the pot; 40% of remaining entrants split 2/3."),
    SIXTY_PERCENT_CONSOLATION("60% of all entrants receive equal payouts from the pot.")
}
