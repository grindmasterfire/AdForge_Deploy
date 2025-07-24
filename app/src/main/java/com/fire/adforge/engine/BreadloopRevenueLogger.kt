package com.fire.adforge.engine

object BreadloopRevenueLogger {
    fun logSessionCoins(userId: String, coinsEarned: Int, durationMs: Long, poolId: String) {
        val seconds = durationMs / 1000
        val logMsg = "[BREADLOOP COINS] User: $userId | Pool: $poolId | Time: ${seconds}s | Coins: $coinsEarned"
        Log.d("BreadloopEarnings", logMsg)
        // Optional: store to Firebase if needed
    }
}
