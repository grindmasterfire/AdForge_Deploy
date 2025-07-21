package com.fire.adforge.raffles

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

object ClanRafflePayoutEngine {
    suspend fun awardCoins(userId: String, amount: Int): Boolean {
        val db = FirebaseFirestore.getInstance()
        val userRef = db.collection("users").document(userId)

        return try {
            db.runTransaction { txn ->
                val snapshot = txn.get(userRef)
                val currentWallet = snapshot.getLong("walletCoins") ?: 0
                val updated = currentWallet + amount
                txn.update(userRef, "walletCoins", updated)
            }.await()
            true
        } catch (e: Exception) {
            false
        }
    }
}
