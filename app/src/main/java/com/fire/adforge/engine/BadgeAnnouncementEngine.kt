package com.fire.adforge.engine

import com.fire.adforge.model.CrewWallPost
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

object BadgeAnnouncementEngine {
    suspend fun postBadgeToCrewWall(userId: String, crewId: String, badgeId: String) {
        val db = FirebaseFirestore.getInstance()
        val post = CrewWallPost(
            postId = "",
            crewId = crewId,
            authorId = userId,
            content = "  just earned the badge: !",
            timestamp = System.currentTimeMillis(),
            type = "badge",
            badgeId = badgeId
        )
        val ref = db.collection("crews").document(crewId).collection("wall").document()
        ref.set(post.copy(postId = ref.id)).await()
    }
}
