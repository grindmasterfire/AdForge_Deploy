package com.fire.adforge.backend

import com.fire.adforge.mail.MailDispatcher

object OnboardingManager {
    fun sendWelcome(userId: String) {
        MailDispatcher.send(
            userId,
            "Welcome to AdForge",
            "Welcome, pilot. Your journey begins here. Earn coins. Enter raffles. Build your crew."
        )
        FounderBadgeManager.grantIfEligible(userId)
    }
}
