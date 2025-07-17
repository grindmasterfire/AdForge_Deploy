package com.fire.adforge.logging

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.Timestamp

object SessionLogger {
    private val db = FirebaseFirestore.getInstance()

    fun logEvent(userId: String, event: String) {
        val log = hashMapOf(
            "userId" to userId,
            "event" to event,
            "timestamp" to Timestamp.now()
        )

        db.collection("session_logs")
            .add(log)
            .addOnSuccessListener {
                Log.d("SessionLogger", "Event logged successfully")
            }
            .addOnFailureListener { e ->
                Log.e("SessionLogger", "Error logging event", e)
            }
    }
}
