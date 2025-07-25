package com.fire.adforge.engine

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import java.util.*

object WallPostReactEngine {
    suspend fun reactWithBadge(postId: String, crewId: String, userId: String, badgeName: String, emoji: String) {
        val db = FirebaseFirestore.getInstance()
        val ref = db.collection("crews").document(crewId)
            .collection("wall").document(postId)
            .collection("reactions").document(userId)

        val reaction = hashMapOf(
            "badge" to badgeName,
            "emoji" to emoji,
            "timestamp" to com.google.firebase.Timestamp.now()
        )

        ref.set(reaction).await()
    }
}
