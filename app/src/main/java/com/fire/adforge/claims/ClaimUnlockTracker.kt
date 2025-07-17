package com.fire.adforge.claims

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.Timestamp

object ClaimUnlockTracker {
    private val db = FirebaseFirestore.getInstance()

    fun recordUnlock(userId: String, claimId: String) {
        val entry = hashMapOf(
            "userId" to userId,
            "claimId" to claimId,
            "timestamp" to Timestamp.now()
        )

        db.collection("claim_unlocks")
            .add(entry)
    }
}
