import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.backend

import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

object MilestoneLogger {
    private val db = FirebaseFirestore.getInstance()
    private val uid = FirebaseAuth.getInstance().currentUser?.uid ?: "anon"

    fun logBoost(offerId: String, coinsSpent: Int) {
        val data = hashMapOf(
            "userId" to uid,
            "coinsSpent" to coinsSpent,
            "source" to "earned",
            "timestamp" to Timestamp.now()
        )
        db.collection("milestones")
            .document(offerId)
            .collection("logs")
            .document(uid)
            .set(data)
    }
}

