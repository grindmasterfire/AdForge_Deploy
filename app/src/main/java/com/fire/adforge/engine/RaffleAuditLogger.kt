package com.fire.adforge.engine

import android.util.Log

object RaffleAuditLogger {
    fun logEntry(userId: String, raffleId: String, poolId: String, type: String) {
        val message = "[AUDIT] $type entry  User: $userId | Raffle: $raffleId | Pool: $poolId"
        Log.d("RaffleAudit", message)
        // Firebase logging optional
    }
}
