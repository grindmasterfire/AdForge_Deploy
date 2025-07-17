import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.backend

import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

object CrewJoiner {

    suspend fun joinCrew(crewId: String): Boolean {
        val userId = FirebaseAuth.getInstance().currentUser?.uid ?: return false
        val db = FirebaseFirestore.getInstance()

        try {
            val crewRef = db.collection("crews").document(crewId)
            val userRef = crewRef.collection("members").document(userId)

            // Write user into members subcollection
            userRef.set(
                mapOf(
                    "joinedAt" to Timestamp.now(),
                    "referral" to "none"
                )
            ).await()

            // Increment memberCount atomically
            crewRef.update("memberCount", com.google.firebase.firestore.FieldValue.increment(1)).await()

            return true
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
    }
    suspend fun leaveCrew(crewId: String): Boolean {
        val userId = FirebaseAuth.getInstance().currentUser?.uid ?: return false
        val db = FirebaseFirestore.getInstance()

        return try {
            val crewRef = db.collection("crews").document(crewId)
            val memberRef = crewRef.collection("members").document(userId)

            // Delete member record
            memberRef.delete().await()

            // Decrement counter
            crewRef.update("memberCount", com.google.firebase.firestore.FieldValue.increment(-1)).await()

            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}

