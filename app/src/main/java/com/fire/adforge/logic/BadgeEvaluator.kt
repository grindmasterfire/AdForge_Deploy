package com.fire.adforge.logic

import com.fire.adforge.model.Badge
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

object BadgeEvaluator {
    suspend fun evaluateAndGrant(userId: String, type: String, value: Int) {
        val badgeId = when (type) {
            "coins" -> if (value >= 5000) "coin_collector" else null
            "raffle" -> if (value >= 3) "jackpot_slayer" else null
            "referral" -> if (value >= 5) "tree_builder" else null
            else -> null
        }
        badgeId?.let { grantBadge(userId, it) }
    }

    private suspend fun grantBadge(userId: String, badgeId: String) {
        val db = FirebaseFirestore.getInstance()
        val badge = Badge(badgeId, System.currentTimeMillis())
        db.collection("users").document(userId).collection("badges").document(badgeId).set(badge).await()
    }
}
