package com.fire.adforge.raffle

object SevenDayRaffle : RaffleEngine {
    private val entrants = mutableListOf<String>()
    private val endTime = System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000

    override fun enter(userId: String): Boolean {
        if (!entrants.contains(userId)) entrants.add(userId)
        return true
    }

    override fun drawWinners(): List<String> {
        return entrants.shuffled().take(5)
    }

    override fun getRemainingTime(): Long {
        return endTime - System.currentTimeMillis()
    }
}
