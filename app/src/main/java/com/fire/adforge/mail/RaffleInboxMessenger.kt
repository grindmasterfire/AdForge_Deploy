package com.fire.adforge.mail

import com.fire.adforge.mail.MailDispatcher

object RaffleInboxMessenger {
    fun notifyWin(userId: String, raffleType: String, prize: Int) {
        val subject = "🎉 You Won a Raffle!"
        val body = "Congrats! You won \ coins in the \ raffle.\n\n🔥 Keep grinding!"
        MailDispatcher.sendPlatformMessage(userId, subject, body)
    }
}
