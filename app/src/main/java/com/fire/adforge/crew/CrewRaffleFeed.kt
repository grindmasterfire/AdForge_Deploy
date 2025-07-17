import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.crew

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

data class CrewResult(
    val crewName: String = "",
    val totalPoints: Int = 0,
    val rank: Int = 0,
    val rewardTier: String = ""
)

object CrewRaffleFeed {

    private val db = FirebaseFirestore.getInstance()

    suspend fun fetchTopCrews(limit: Long = 10): List<CrewResult> {
        return try {
            val snapshot = db.collection("crew_results")
                .orderBy("totalPoints", com.google.firebase.firestore.Query.Direction.DESCENDING)
                .limit(limit)
                .get().await()

            snapshot.documents.mapIndexed { index, doc ->
                CrewResult(
                    crewName = doc.getString("crewName") ?: "Unknown",
                    totalPoints = doc.getLong("totalPoints")?.toInt() ?: 0,
                    rank = index + 1,
                    rewardTier = doc.getString("rewardTier") ?: "none"
                )
            }
        } catch (e: Exception) {
            Log.e("CrewRaffleFeed", "Failed to fetch crew results", e)
            emptyList()
        }
    }
}

