import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.engine

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

object FounderRankAssigner {
    private val db = FirebaseFirestore.getInstance()

    suspend fun assignRankIfEligible(userId: String) {
        val userRef = db.collection("users").document(userId)
        val userDoc = userRef.get().await()
        if (userDoc.contains("founderRank")) return

        val foundersSnapshot = db.collection("users")
            .whereGreaterThan("founderRank", 0)
            .get().await()

        if (foundersSnapshot.size() >= 1000) return

        val newRank = foundersSnapshot.size() + 1
        userRef.update("founderRank", newRank)
    }
}

