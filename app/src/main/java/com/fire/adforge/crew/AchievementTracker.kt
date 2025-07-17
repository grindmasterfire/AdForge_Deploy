package com.fire.adforge.crew

import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

object AchievementTracker {
    private val db = FirebaseFirestore.getInstance()

    fun unlock(userId: String, badgeId: String) {
        val badge = hashMapOf(
            "userId" to userId,
            "badgeId" to badgeId,
            "unlockedAt" to Date().time
        )
        db.collection("user_achievements").add(badge)
    }
}
