package com.fire.adforge.raffle

interface RaffleEngine {
    fun enter(userId: String): Boolean
    fun drawWinners(): List<String>
    fun getRemainingTime(): Long
}
