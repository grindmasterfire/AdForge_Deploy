package com.fire.adforge.referrals

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.Timestamp

object ReferralBonusTagger {
    private val db = FirebaseFirestore.getInstance()

    fun tagBonus(referrerId: String, bonusAmount: Long) {
        val record = hashMapOf(
            "referrerId" to referrerId,
            "bonusAmount" to bonusAmount,
            "timestamp" to Timestamp.now()
        )

        db.collection("referral_bonuses")
            .add(record)
    }
}
