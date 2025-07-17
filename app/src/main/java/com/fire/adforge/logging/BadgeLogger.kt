package com.fire.adforge.logging

import com.google.firebase.firestore.FirebaseFirestore

object BadgeLogger {
    private val db = FirebaseFirestore.getInstance()

    fun log(userId: String, badgeId: String) {
        val data = mapOf(
            "badgeId" to badgeId,
            "userId" to userId,
            "timestamp" to System.currentTimeMillis()
        )
        db.collection("logs").document("badges")
            .collection("unlocks").add(data)
    }
}
