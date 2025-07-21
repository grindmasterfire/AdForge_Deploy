package com.fire.adforge.viewmodel

import com.google.firebase.firestore.FirebaseFirestore
import com.fire.adforge.model.Referral

class ReferralEngine {

    private val db = FirebaseFirestore.getInstance()

    fun distributeReferralEarnings(userId: String, earnedAmount: Int) {
        db.collection("referrals").document(userId).get().addOnSuccessListener { doc ->
            val referral = doc.toObject(Referral::class.java)
            referral?.let {
                val payouts = listOf(0.10, 0.05, 0.03, 0.01)
                val tiers = listOf(it.referredBy) + it.tier1 + it.tier2 + it.tier3
                for ((i, refId) in tiers.withIndex()) {
                    refId?.let { id ->
                        val reward = (earnedAmount * payouts.getOrNull(i)!!).toInt()
                        db.collection("wallets").document(id).update("coins", com.google.firebase.firestore.FieldValue.increment(reward.toLong()))
                    }
                }
            }
        }
    }
}
