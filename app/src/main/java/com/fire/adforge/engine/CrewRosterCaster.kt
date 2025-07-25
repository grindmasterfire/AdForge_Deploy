package com.fire.adforge.engine

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.Timestamp

object CrewRosterCaster {

    suspend fun announceCrewRoster(crewId: String) {
        val db = FirebaseFirestore.getInstance()
        val crewRef = db.collection("crews").document(crewId)

        crewRef.collection("members")
            .get()
            .addOnSuccessListener { snapshot ->
                val members = snapshot.mapNotNull { it.getString("username") }
                val topGrinder = members.randomOrNull() ?: "unknown"

                val message = buildString {
                    appendLine(" CREW ROLL CALL: ")
                    appendLine(" Weekly MVP: @")
                    appendLine(" Members:")
                    members.forEach { appendLine("- @") }
                }

                val post = hashMapOf(
                    "authorId" to "CipherBot",
                    "text" to message,
                    "timestamp" to Timestamp.now()
                )

                db.collection("cipher_wall").add(post)
            }
    }
}
