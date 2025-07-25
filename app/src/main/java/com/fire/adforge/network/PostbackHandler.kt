package com.fire.adforge.network

import com.fire.adforge.engine.SponsorAttribution
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

object PostbackHandler {
    suspend fun handlePostback(sponsor: String, userId: String, coins: Int) {
        val db = FirebaseFirestore.getInstance()
        val userRef = db.collection("users").document(userId)
        db.runBatch { batch ->
            batch.update(userRef, "walletCoins", com.google.firebase.firestore.FieldValue.increment(coins.toLong()))
        }.await()

        SponsorAttribution.logAttribution(sponsor, userId, coins)
    }
}
