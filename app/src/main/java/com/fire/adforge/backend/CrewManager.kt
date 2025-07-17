import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.backend

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

object CrewManager {

    suspend fun promoteMember(crewId: String, memberId: String): Boolean {
        val db = FirebaseFirestore.getInstance()
        val leaderId = FirebaseAuth.getInstance().currentUser?.uid ?: return false
        val doc = db.collection("crews").document(crewId).get().await()
        if (doc.getString("creatorId") != leaderId) return false

        db.collection("crews").document(crewId)
            .collection("members")
            .document(memberId)
            .update("role", "co-leader")
            .await()

        return true
    }

    suspend fun kickMember(crewId: String, memberId: String): Boolean {
        val db = FirebaseFirestore.getInstance()
        val leaderId = FirebaseAuth.getInstance().currentUser?.uid ?: return false
        val doc = db.collection("crews").document(crewId).get().await()
        if (doc.getString("creatorId") != leaderId) return false

        db.collection("crews").document(crewId)
            .collection("members")
            .document(memberId)
            .delete()
            .await()

        return true
    }
    suspend fun togglePrivacy(crewId: String, makePublic: Boolean): Boolean {
        val db = FirebaseFirestore.getInstance()
        val leaderId = FirebaseAuth.getInstance().currentUser?.uid ?: return false
        val doc = db.collection("crews").document(crewId).get().await()
        if (doc.getString("creatorId") != leaderId) return false

        db.collection("crews").document(crewId)
            .update("isPublic", makePublic)
            .await()
        return true
    }
}

