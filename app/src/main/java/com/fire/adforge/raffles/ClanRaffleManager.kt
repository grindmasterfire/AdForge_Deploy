package com.fire.adforge.raffles

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object ClanRaffleManager {
    suspend fun enterClanRaffle(
        userId: String,
        clanId: String,
        raffleId: String,
        entryType: String
    ): Boolean = withContext(Dispatchers.IO) {
        try {
            ClanRaffleLedger.logClanEntry(userId, clanId, raffleId, entryType)
            true
        } catch (e: Exception) {
            false
        }
    }
}
