package com.fire.adforge.backend

import com.fire.adforge.model.CrewMeta
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

object CrewManager {

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    fun joinOrCreateCrew(crewName: String) {
        val uid = auth.currentUser?.uid ?: return

        // Update user record
        db.collection("users").document(uid).update("crewName", crewName)

        // Create or update crew document
        val crewDoc = db.collection("crews").document(crewName)
        crewDoc.get().addOnSuccessListener { snapshot ->
            if (snapshot.exists()) {
                crewDoc.update("members", snapshot.get("members") as? List<String> + uid)
            } else {
                val crew = CrewMeta(
                    crewName = crewName,
                    founderUid = uid,
                    members = listOf(uid),
                    multiplier = 1.1
                )
                crewDoc.set(crew)
            }
        }
    }
}
