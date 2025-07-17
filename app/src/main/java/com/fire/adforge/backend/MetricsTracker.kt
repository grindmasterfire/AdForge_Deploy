package com.fire.adforge.backend

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

// Core user metrics for activity tracking and analytics
data class UserMetrics(
    val totalOffersCompleted: Int = 0,
    val totalRaffleWins: Int = 0,
    val totalCoinsEarned: Int = 0,
    val totalInvitesSent: Int = 0
)

object MetricsTracker {
    private val db = FirebaseFirestore.getInstance()

    // Fetch metrics from Firestore or return defaults
    suspend fun fetchMetrics(userId: String): UserMetrics {
        val doc = db.collection("metrics").document(userId).get().await()
        return doc.toObject(UserMetrics::class.java) ?: UserMetrics()
    }

    // Atomically increment a field (e.g., raffleWins += 1)
    suspend fun updateMetric(userId: String, field: String, delta: Int) {
        val ref = db.collection("metrics").document(userId)
        db.runTransaction { tx ->
            val snapshot = tx.get(ref)
            val current = snapshot.getLong(field) ?: 0L
            tx.update(ref, field, current + delta)
        }.await()
    }

    // Replace entire document with new values
    suspend fun setMetric(userId: String, newMetrics: UserMetrics) {
        db.collection("metrics").document(userId).set(newMetrics).await()
    }
}
