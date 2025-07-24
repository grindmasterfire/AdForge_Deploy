package com.adforge.clan

import com.adforge.raffle.RaffleType
import com.adforge.raffle.TicketLedger

object ClanRafflePool {
    private val clanPools = mutableMapOf<String, MutableList<String>>() // clanId -> userIds

    fun enterClanRaffle(clanId: String, userId: String, type: RaffleType) {
        val pool = clanPools.getOrPut(clanId) { mutableListOf() }
        pool.add(userId)
        // Optionally: mirror to ticket ledger
        TicketLedger.logEntry(userId, type, count = 1)
    }

    fun getClanEntries(clanId: String): List<String> {
        return clanPools[clanId]?.toList() ?: emptyList()
    }

    fun clearClan(clanId: String) {
        clanPools.remove(clanId)
    }

    fun all(): Map<String, List<String>> = clanPools
}
