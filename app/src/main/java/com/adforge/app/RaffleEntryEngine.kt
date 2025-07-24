package com.adforge.app

import android.util.Log

object RaffleEntryEngine {
    fun recordEntry(source: String) {
        val multiplier = getCrewMultiplier()
        val referralBonus = getReferralBonus()
        val userId = getUserId()

        val allowed = DailyRaffle.enterRaffle(userId)
        if (!allowed) {
            Log.d("RaffleEntry", "Entry blocked  daily cap hit.")
            return
        }

        Log.d("RaffleEntry", "Source: \")
        Log.d("RaffleEntry", "Crew Multiplier: x\")
        Log.d("RaffleEntry", "Referral Tier Bonus: +\%")
    }

    private fun getCrewMultiplier(): Double {
        val crewSize = 5
        return when {
            crewSize >= 20 -> 2.0
            crewSize >= 10 -> 1.5
            crewSize >= 5  -> 1.2
            else -> 1.0
        }
    }

    private fun getReferralBonus(): Int {
        val tierLevel = 2
        return when (tierLevel) {
            1 -> 10
            2 -> 5
            3 -> 3
            4 -> 1
            else -> 0
        }
    }

    private fun getUserId(): String {
        return "user123" // stub for now
    }
}
