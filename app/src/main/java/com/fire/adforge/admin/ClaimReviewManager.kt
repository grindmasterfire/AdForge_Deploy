import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.admin

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

data class ClaimAudit(
    val userId: String = "",
    val claimId: String = "",
    val amount: Int = 0,
    val method: String = "", // PayPal, Venmo, etc.
    val timestamp: Long = 0,
    val status: String = "pending", // pending, approved, denied
    val reviewer: String? = null
)

object ClaimReviewManager {

    private val db = FirebaseFirestore.getInstance()

    suspend fun fetchPendingClaims(): List<ClaimAudit> {
        return try {
            val snapshot = db.collection("claim_requests")
                .whereEqualTo("status", "pending")
                .get().await()

            snapshot.toObjects(ClaimAudit::class.java)
        } catch (e: Exception) {
            Log.e("ClaimReviewManager", "Failed to fetch claims", e)
            emptyList()
        }
    }

    suspend fun updateClaimStatus(claimId: String, newStatus: String, reviewerId: String) {
        try {
            val docRef = db.collection("claim_requests").document(claimId)
            docRef.update(
                mapOf(
                    "status" to newStatus,
                    "reviewer" to reviewerId
                )
            ).await()
        } catch (e: Exception) {
            Log.e("ClaimReviewManager", "Failed to update claim", e)
        }
    }
}

