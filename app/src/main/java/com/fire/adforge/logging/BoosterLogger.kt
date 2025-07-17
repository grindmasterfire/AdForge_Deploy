import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.logging

import com.google.firebase.firestore.FirebaseFirestore

object BoosterLogger {

    private val db = FirebaseFirestore.getInstance()

    fun logBooster(userId: String, boosterType: String, coinsSpent: Long) {
        val entry = mapOf(
            "type" to boosterType,
            "coins" to coinsSpent,
            "timestamp" to System.currentTimeMillis()
        )
        db.collection("users").document(userId)
            .collection("booster_logs")
            .add(entry)
    }
}

