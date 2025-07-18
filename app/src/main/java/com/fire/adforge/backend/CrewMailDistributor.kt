package com.fire.adforge.backend

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

object CrewMailDistributor {

    private val db = FirebaseFirestore.getInstance()

    suspend fun sendMessageToCrew(crewName: String, subject: String, body: String) {
        val crewDoc = db.collection("crews").document(crewName).get().await()
        val members = crewDoc.get("members") as? List<String> ?: return

        val mail = mapOf(
            "title" to subject,
            "body" to body,
            "timestamp" to System.currentTimeMillis()
        )

        members.forEach { uid ->
            db.collection("users")
              .document(uid)
              .collection("mailbox")
              .add(mail)
        }
    }
}
