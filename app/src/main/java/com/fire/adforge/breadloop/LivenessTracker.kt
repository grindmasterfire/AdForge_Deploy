import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.breadloop

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

data class LivenessEvent(
    val userId: String = "",
    val sessionId: String = "",
    val bubbleShownAt: Long = 0L,
    val respondedAt: Long = 0L,
    val accepted: Boolean = false
)

object LivenessTracker {

    private val db = FirebaseFirestore.getInstance()

    suspend fun logBubbleEvent(
        userId: String,
        sessionId: String,
        bubbleShownAt: Long,
        respondedAt: Long,
        accepted: Boolean
    ) {
        try {
            val event = LivenessEvent(
                userId = userId,
                sessionId = sessionId,
                bubbleShownAt = bubbleShownAt,
                respondedAt = respondedAt,
                accepted = accepted
            )

            db.collection("liveness_log").add(event).await()

        } catch (e: Exception) {
            Log.e("LivenessTracker", "Failed to log event", e)
        }
    }
}

