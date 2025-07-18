package com.fire.adforge.backend

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

object CrewRaffleWriter {

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    fun submitCrewRaffleTicket() {
        val uid = auth.currentUser?.uid ?: return
        val userRef = db.collection("users").document(uid)

        userRef.get().addOnSuccessListener { doc ->
            val crew = doc.getString("crewName") ?: return@addOnSuccessListener
            val ticketEntry = mapOf(
                "uid" to uid,
                "timestamp" to System.currentTimeMillis()
            )
            db.collection("crew_raffles")
                .document(crew)
                .collection("entries")
                .add(ticketEntry)
        }
    }
}
