package com.fire.adforge.crew

import com.google.firebase.firestore.FirebaseFirestore

object CrewGrindScoreEngine {
    private val db = FirebaseFirestore.getInstance()

    fun incrementScore(crewId: String, points: Int = 1) {
        val ref = db.collection("crew_scores").document(crewId)
        db.runTransaction { tx ->
            val snapshot = tx.get(ref)
            val current = snapshot.getLong("score") ?: 0L
            tx.update(ref, "score", current + points)
        }
    }
}
