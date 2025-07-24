package com.adforge.app

import android.util.Log

object DailyRaffle {
    private const val MAX_TICKETS = 100
    private val entries = mutableListOf<String>()

    fun enterRaffle(userId: String): Boolean {
        return if (entries.size >= MAX_TICKETS) {
            Log.d("DailyRaffle", "Entry denied  cap reached.")
            false
        } else {
            entries.add(userId)
            Log.d("DailyRaffle", "Ticket accepted for user: \ (\/\)")
            true
        }
    }

    fun resetDaily() {
        entries.clear()
        Log.d("DailyRaffle", "Raffle pool cleared for new day.")
    }
}
