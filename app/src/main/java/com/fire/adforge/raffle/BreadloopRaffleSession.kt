package com.fire.adforge.raffle

import android.util.Log

object BreadloopRaffleSession {
    private val activeUsers = mutableSetOf<String>()

    fun promptLiveness(userId: String): Boolean {
        Log.d("BreadloopLiveness", "Pinged liveness check for \")
        return true // Simulated user presence
    }

    fun joinSession(userId: String, coinsAvailable: Int): Boolean {
        return if (promptLiveness(userId) && coinsAvailable >= 10) {
            activeUsers.add(userId)
            Log.d("Breadloop", "User \ joined session raffle")
            true
        } else {
            Log.d("Breadloop", "User \ failed liveness or balance")
            false
        }
    }
}
