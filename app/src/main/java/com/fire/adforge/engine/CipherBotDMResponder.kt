package com.fire.adforge.engine

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.Timestamp

object CipherBotDMResponder {

    private val knownCommands = mapOf(
        "help" to " Need help? Try grinding, winning, and staying hydrated.",
        "codex" to " Codex Rule #1: Never buy coins. Earn everything.",
        "raffle" to " Raffles run daily, weekly, and every 21 days. Crew up!",
        "badges" to " You earn badges by grinding, not whining.",
        "uncle" to " Uncle Cipher says: If you're reading this, you're grinding right."
    )

    suspend fun handleDM(fromUser: String, message: String) {
        val db = FirebaseFirestore.getInstance()
        val trimmed = message.trim().lowercase()

        val response = knownCommands.entries.find { trimmed.contains(it.key) }?.value
            ?: " I'm CipherBot. I post memes, announce wins, and track legends. Try typing 'help', 'codex', or 'badges'."

        val reply = hashMapOf(
            "from" to "CipherBot",
            "to" to fromUser,
            "message" to response,
            "timestamp" to Timestamp.now()
        )

        db.collection("dm_mailbox").add(reply)
    }
}
