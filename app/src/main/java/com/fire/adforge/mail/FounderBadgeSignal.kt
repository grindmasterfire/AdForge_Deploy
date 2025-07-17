package com.fire.adforge.mail

object FounderBadgeSignal {
    fun notify(userId: String) {
        MailDispatcher.send(
            userId,
            "🌟 Alpha Founder Badge Granted",
            "You're one of the first 1,000 users on AdForge. You've unlocked the exclusive Alpha Founder badge!"
        )
    }
}
