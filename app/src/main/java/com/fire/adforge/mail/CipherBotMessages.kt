package com.fire.adforge.mail

object CipherBotMessages {
    fun welcome(userId: String): Pair<String, String> {
        val subject = "Welcome to AdForge!"
        val body = "Hey \,\n\nWelcome aboard! Earn coins, join raffles, and climb the Forge.\n\n🔥 Let the grind begin.\n\n— CipherBot"
        return subject to body
    }

    fun crewJoined(crewId: String): Pair<String, String> {
        val subject = "You joined Crew \!"
        val body = "Welcome to Crew \. Rack up coins, win crew raffles, and rise in rank.\n\n— CipherBot"
        return subject to body
    }

    fun prizeWon(prize: String): Pair<String, String> {
        val subject = "🎉 You won: \!"
        val body = "Congratulations! You just won \ in a raffle. Keep forging your fortune.\n\n— CipherBot"
        return subject to body
    }
}
