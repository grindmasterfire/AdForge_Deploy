package com.fire.adforge.raffles

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.Timestamp

object LivenessRaffleEntry {
    private val db = FirebaseFirestore.getInstance()

    fun recordEntry(userId: String, sessionId: String, ticketCount: Int) {
        val entry = hashMapOf(
            "userId" to userId,
            "sessionId" to sessionId,
            "ticketCount" to ticketCount,
            "timestamp" to Timestamp.now()
        )

        db.collection("liveness_raffle_entries")
            .add(entry)
    }
}
