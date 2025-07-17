package com.fire.adforge.mail

import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

object MailDispatcher {
    private val db = FirebaseFirestore.getInstance()

    fun sendMail(fromId: String, toId: String, subject: String, body: String) {
        val message = hashMapOf(
            "from" to fromId,
            "to" to toId,
            "subject" to subject,
            "body" to body,
            "timestamp" to Date()
        )
        db.collection("mailbox").add(message)
    }

    fun sendPlatformMessage(toId: String, subject: String, body: String) {
        sendMail("CipherBot", toId, subject, body)
    }
}
