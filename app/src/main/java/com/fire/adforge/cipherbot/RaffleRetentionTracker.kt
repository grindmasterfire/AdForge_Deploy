package com.fire.adforge.cipherbot

import com.google.firebase.firestore.FirebaseFirestore

object RaffleRetentionTracker {
    private val db = FirebaseFirestore.getInstance()

    fun logReturnEntry(userId: String, raffleId: String, result: String) {
        val record = mapOf(
            "userId" to userId,
            "raffleId" to raffleId,
            "result" to result,
            "timestamp" to System.currentTimeMillis(),
            "type" to "retention"
        )
        db.collection("retention_logs").add(record)
    }
}
