package com.fire.adforge.engine

import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

object AmoeLedger {
    suspend fun logAmoeTicket(userId: String, raffleId: String, livenessMillis: Long) {
        val db = FirebaseFirestore.getInstance()
        val entry = hashMapOf(
            "userId" to userId,
            "raffleId" to raffleId,
            "livenessTimeMs" to livenessMillis,
            "timestamp" to Timestamp.now()
        )
        db.collection("amoe_log").add(entry).await()
    }
}
