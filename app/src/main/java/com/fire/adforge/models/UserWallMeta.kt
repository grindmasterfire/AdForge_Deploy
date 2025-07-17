package com.fire.adforge.models

data class UserWallMeta(
    val userId: String = "",
    val avatarUrl: String = "",
    val backgroundUrl: String = "",
    val currentGrindStatus: Boolean = false,
    val achievements: List<String> = emptyList(),
    val crewId: String = ""
)
