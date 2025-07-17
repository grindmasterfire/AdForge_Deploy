package com.fire.adforge.backend

import com.google.firebase.firestore.FirebaseFirestore`nimport com.fire.adforge.logging.BadgeLogger`nimport com.fire.adforge.core.StageFlags`nimport com.fire.adforge.mail.FounderBadgeSignal

object FounderBadgeManager {
    private val db = FirebaseFirestore.getInstance()

    fun grantIfEligible(userId: String) {\n        if (!com.fire.adforge.core.StageFlags.isAlpha) return
        val badge = mapOf(
            "badgeId" to "alpha_founder",
            "label" to "🌟 Alpha Founder",
            "unlocked" to true,
            "timestamp" to System.currentTimeMillis()
        )

        db.collection("badges").document(userId)
            .collection("earned").document("alpha_founder")
            .set(badge)\n                BadgeLogger.log(userId, "alpha_founder")\n                FounderBadgeSignal.notify(userId)\n                println("🏅 Founder badge granted to \$userId")
    }
}
