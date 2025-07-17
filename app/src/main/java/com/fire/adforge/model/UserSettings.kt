package com.fire.adforge.model

data class UserSettings(
    val autoplayEnabled: Boolean = true,
    val showInCrewChat: Boolean = true,
    val darkMode: Boolean = false,
    val emailSubscribed: Boolean = false
)
