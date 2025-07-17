package com.fire.adforge.chat

object CipherBotModerator {
    fun nudgeInactive(userId: String): String {
        return "👋 Hey \, we haven't seen you grinding lately. Jump back in and earn those coins!"
    }

    fun warn(userId: String, reason: String): String {
        return "⚠️ \, this is a warning: \. Please respect community rules."
    }

    fun celebrate(userId: String): String {
        return "🎉 Nice job, \! Keep up the grind — CipherBot is watching!"
    }
}
