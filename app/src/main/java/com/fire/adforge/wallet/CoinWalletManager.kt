package com.fire.adforge.wallet

import com.google.firebase.firestore.FirebaseFirestore

object CoinWalletManager {
    private val db = FirebaseFirestore.getInstance()

    fun deductCoins(userId: String, amount: Int, onComplete: (Boolean) -> Unit) {
        val ref = db.collection("wallets").document(userId)
        db.runTransaction { tx ->
            val snapshot = tx.get(ref)
            val current = snapshot.getLong("coins") ?: 0L
            if (current >= amount) {
                tx.update(ref, "coins", current - amount)
                true
            } else false
        }.addOnSuccessListener { success ->
            onComplete(success)
        }.addOnFailureListener {
            onComplete(false)
        }
    }
}
