package com.fire.adforge.backend

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

object SurveyLogWriter {

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    fun logSurveyVisit(provider: String) {
        val uid = auth.currentUser?.uid ?: return
        val entry = mapOf(
            "provider" to provider,
            "timestamp" to System.currentTimeMillis()
        )
        db.collection("users")
          .document(uid)
          .collection("survey_visits")
          .add(entry)
    }
}
