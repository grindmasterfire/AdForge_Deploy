package com.fire.adforge.backend

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

data class CipherLog(
    val userId: String = "",
    val timestamp: Long = System.currentTimeMillis(),
    val type: String = "", // "chat", "command", "system"
    val content: String = ""
)

object CipherUplink {
    private val db = FirebaseFirestore.getInstance()

    suspend fun logEvent(userId: String, type: String, content: String) {
        val log = CipherLog(userId = userId, type = type, content = content)
        db.collection("cipher_uplink").add(log).await()
    }

    suspend fun getRecentCommands(userId: String, limit: Long = 5): List<String> {
        val snapshot = db.collection("cipher_uplink")
            .whereEqualTo("userId", userId)
            .whereEqualTo("type", "command")
            .orderBy("timestamp", com.google.firebase.firestore.Query.Direction.DESCENDING)
            .limit(limit)
            .get().await()

        return snapshot.documents.mapNotNull { it.getString("content") }
    }

    suspend fun detectRepeatCommand(userId: String, current: String): Boolean {
        val history = getRecentCommands(userId, 5)
        return history.count { it.trim().equals(current.trim(), ignoreCase = true) } >= 2
    }

    suspend fun suggestAutoReply(command: String): String? {
        val triggers = mapOf(
            "how to earn coins" to "Try autoplay ads or install apps from the OfferWall.",
            "what is raffle" to "Raffles let you win coins by spending your entries wisely!",
            "invite crew" to "Use your referral link from your profile to grow your crew.",
            "where my payout" to "Check the Wallet tab — payout status is updated daily."
        )

        return triggers.entries.find { command.contains(it.key, ignoreCase = true) }?.value
    }
}
