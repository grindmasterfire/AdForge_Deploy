package com.fire.adforge.raffles

import kotlinx.coroutines.*
import java.util.*

object ClanRaffleScheduler {
    private val timers = mutableMapOf<String, Timer>()

    fun scheduleRaffle(clanId: String, raffleId: String, durationMs: Long, onEnd: () -> Unit) {
        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                onEnd()
            }
        }, durationMs)
        timers[raffleId] = timer
    }

    fun cancelRaffle(raffleId: String) {
        timers[raffleId]?.cancel()
        timers.remove(raffleId)
    }
}
