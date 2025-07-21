package com.fire.adforge.engine

import com.fire.adforge.model.ClanWallPost
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

object ClanBadgeBroadcaster {
    suspend fun postBadgeToClanWall(userId: String, clanId: String, badgeId: String) {
        val db = FirebaseFirestore.getInstance()
        val post = ClanWallPost(
            postId = "",
            clanId = clanId,
            authorId = userId,
            content = "  earned a rare clan badge: ",
            timestamp = System.currentTimeMillis(),
            type = "badge",
            badgeId = badgeId
        )
        val ref = db.collection("clans").document(clanId).collection("wall").document()
        ref.set(post.copy(postId = ref.id)).await()
    }
}
