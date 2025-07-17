package com.fire.adforge.models

data class CrewBadgeMeta(
    val badgeId: String = "",
    val name: String = "",
    val iconUrl: String = "",
    val description: String = "",
    val earned: Boolean = false,
    val unlockedTimestamp: Long = 0L
)
