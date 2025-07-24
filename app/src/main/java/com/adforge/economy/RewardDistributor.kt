package com.adforge.economy

import com.adforge.raffle.RaffleType
import com.adforge.raffle.TicketLedger
import com.adforge.raffle.WinnerDraw

object RewardDistributor {

    fun distribute(type: RaffleType, totalPot: Int) {
        val winners = WinnerDraw.drawWinners(type)
        val uniqueWinners = winners.distinct()

        when (type) {
            RaffleType.WINNER_TAKES_ALL -> {
                val winner = uniqueWinners.firstOrNull() ?: return
                CoinWallet.addCoins(winner, totalPot)
            }

            RaffleType.TIERED_PLUS_40_SPLIT -> {
                val top3 = uniqueWinners.take(3)
                val remaining = uniqueWinners.drop(3)

                val oneThird = totalPot / 3
                if (top3.size >= 3) {
                    CoinWallet.addCoins(top3[0], oneThird * 50 / 100)
                    CoinWallet.addCoins(top3[1], oneThird * 30 / 100)
                    CoinWallet.addCoins(top3[2], oneThird * 20 / 100)
                }

                val splitAmount = (totalPot - oneThird) / remaining.size
                remaining.forEach { CoinWallet.addCoins(it, splitAmount) }
            }

            RaffleType.SIXTY_PERCENT_CONSOLATION -> {
                val eachReward = totalPot / uniqueWinners.size
                uniqueWinners.forEach { CoinWallet.addCoins(it, eachReward) }
            }
        }

        TicketLedger.clearLedger(type)
    }
}
