package com.fire.adforge.engine

import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

object MilestoneBoosterLedger {
    suspend fun activateBooster(userId: String, sponsorId: String, cost: Int): Boolean {
        val db = FirebaseFirestore.getInstance()
        val userRef = db.collection("users").document(userId)

        val snapshot = userRef.get().await()
        val walletCoins = (snapshot.getLong("walletCoins") ?: 0).toInt()
        if (walletCoins < cost) return false

        val ledgerEntry = hashMapOf(
            "userId" to userId,
            "sponsorId" to sponsorId,
            "timestamp" to Timestamp.now(),
            "coinsSpent" to cost
        )

        val batch = db.batch()
        batch.update(userRef, "walletCoins", walletCoins - cost)
        batch.set(db.collection("booster_burn_log").document(), ledgerEntry)
        batch.commit().await()
        return true
    }
}
