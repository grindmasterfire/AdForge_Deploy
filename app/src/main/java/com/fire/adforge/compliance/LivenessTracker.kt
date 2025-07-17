package com.fire.adforge.compliance

import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

object LivenessTracker {
    private val db = FirebaseFirestore.getInstance()

    fun markAlive(userId: String) {
        val data = hashMapOf(
            "userId" to userId,
            "verifiedAt" to Date()
        )
        db.collection("liveness_checks").add(data)
    }
}
