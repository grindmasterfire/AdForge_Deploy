package com.fire.adforge.logic

import com.fire.adforge.backend.CipherUplink
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object CipherBotResponder {

    suspend fun handleUserCommand(userId: String, input: String): String {
        CipherUplink.logEvent(userId, "command", input)

        val isRepeat = CipherUplink.detectRepeatCommand(userId, input)
        if (isRepeat) return "⚠️ You already asked that, commander."

        val suggestion = CipherUplink.suggestAutoReply(input)
        return suggestion ?: "🤖 I'm still learning. Try a different command."
    }
}
