package com.fire.adforge.crew

import com.google.firebase.firestore.FirebaseFirestore

object ReferralBonusDistributor {
    private val db = FirebaseFirestore.getInstance()
    private val percentages = listOf(0.10, 0.05, 0.03, 0.01)

    fun distribute(userId: String, amount: Int, upline: List<String>) {
        upline.take(4).forEachIndexed { index, referrerId ->
            val bonus = (amount * percentages[index]).toInt()
            val ref = db.collection("wallets").document(referrerId)

            db.runTransaction { tx ->
                val snap = tx.get(ref)
                val current = snap.getLong("coins") ?: 0L
                tx.update(ref, "coins", current + bonus)
            }.addOnSuccessListener {
                println("Referral bonus of \ sent to \")
            }.addOnFailureListener {
                println("Failed to send referral bonus to \")
            }
        }
    }
}
