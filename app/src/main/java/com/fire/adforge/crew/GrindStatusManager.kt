package com.fire.adforge.crew

import com.google.firebase.firestore.FirebaseFirestore

object GrindStatusManager {
    private val db = FirebaseFirestore.getInstance()

    fun setStatus(userId: String, isGrinding: Boolean) {
        val ref = db.collection("grind_status").document(userId)
        val data = mapOf("active" to isGrinding)
        ref.set(data)
    }

    fun getStatus(userId: String, callback: (Boolean) -> Unit) {
        val ref = db.collection("grind_status").document(userId)
        ref.get().addOnSuccessListener {
            val active = it.getBoolean("active") ?: false
            callback(active)
        }.addOnFailureListener {
            callback(false)
        }
    }
}
