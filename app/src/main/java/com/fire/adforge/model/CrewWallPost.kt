package com.fire.adforge.model

data class CrewWallPost(
    val postId: String = "",
    val crewId: String = "",
    val authorId: String = "",
    val content: String = "",
    val timestamp: Long = 0L,
    val type: String = "message", // or "badge"
    val badgeId: String? = null
)
