package com.fire.adforge.engine

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import java.util.*

object SponsorAttribution {
    suspend fun logAttribution(sponsor: String, userId: String, coins: Int) {
        val db = FirebaseFirestore.getInstance()
        val entry = hashMapOf(
            "timestamp" to Date(),
            "coins" to coins,
            "source" to sponsor
        )
        db.collection("sponsor_logs").document(sponsor)
            .collection(userId).add(entry).await()
    }
}
