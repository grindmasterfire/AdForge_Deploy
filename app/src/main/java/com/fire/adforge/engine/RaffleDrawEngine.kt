package com.fire.adforge.engine

import android.util.Log
import java.util.*
import kotlin.random.Random

object RaffleDrawEngine {
    fun checkAndDraw(poolId: String, raffleId: String, entries: List<String>) {
        if (entries.size < 5) {
            Log.d("RaffleDraw", "Not enough entries to draw for $raffleId in $poolId.")
            return
        }

        val winnerIndex = Random.nextInt(entries.size)
        val winnerId = entries[winnerIndex]
        val drawTime = Date().toString()

        Log.d("RaffleDraw", " Winner: $winnerId | Raffle: $raffleId | Pool: $poolId at $drawTime")

        // Pseudo-write to Firebase
        // db.collection("/raffles/$poolId/$raffleId/results").document("winner").set(winnerId)
        // db.collection("/raffles/$poolId/$raffleId/results").document("metadata").set({ time: drawTime })

        // Mark raffle as drawn
        // db.collection("/raffles/$poolId/$raffleId/").document("status").set("complete")
    }
}
