package com.fire.adforge.model

data class ClanWallPost(
    val postId: String = "",
    val clanId: String = "",
    val authorId: String = "",
    val content: String = "",
    val timestamp: Long = 0L,
    val type: String = "message", // or "badge", "spotlight"
    val badgeId: String? = null
)
