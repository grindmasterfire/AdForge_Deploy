package com.fire.adforge.model

data class MailTemplate(
    val id: String,
    val subject: String,
    val body: String
)

object MailTemplates {
    val systemTemplates = listOf(
        MailTemplate(
            id = "welcome",
            subject = "🧭 Welcome to AdForge!",
            body = "Welcome aboard, Commander. Your grind begins now. Explore offers, rack coins, and enter raffles to win."
        ),
        MailTemplate(
            id = "raffle_win",
            subject = "🎉 You won a raffle!",
            body = "Congratulations! You’ve won an AdForge raffle. Check your wallet and brag to your crew."
        ),
        MailTemplate(
            id = "crew_invite_boost",
            subject = "🔥 Your crew invite boosted earnings",
            body = "A new recruit joined via your referral. You earned bonus coins and pushed your crew rank higher!"
        ),
        MailTemplate(
            id = "security_alert",
            subject = "🔐 Security Alert",
            body = "We've detected a login from a new device. If this wasn’t you, change your password immediately."
        )
    )
}
