package com.fire.adforge.raffles

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object ClanRaffleMacroEngine {

    suspend fun runFullDrawCycle(
        clanId: String,
        raffleId: String,
        raffleType: String,
        rewardAmount: Int
    ): Boolean = withContext(Dispatchers.IO) {
        try {
            val winnerId = ClanDrawEngine.drawWinner(clanId, raffleId)
            if (winnerId != null) {
                val payoutSuccess = ClanRafflePayoutEngine.awardCoins(winnerId, rewardAmount)
                if (payoutSuccess) {
                    ClanRaffleAuditLog.logWinner(clanId, raffleId, winnerId, rewardAmount, raffleType)
                    return@withContext true
                }
            }
            false
        } catch (e: Exception) {
            false
        }
    }
}
