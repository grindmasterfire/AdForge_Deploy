import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.session

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

object SessionCoinTracker {

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    suspend fun logSessionCoins(sessionId: String, earned: Int, retained: Int) {
        val uid = auth.currentUser?.uid ?: return

        try {
            db.collection("session_ledger").document("\-\")
                .set(
                    mapOf(
                        "userId" to uid,
                        "sessionId" to sessionId,
                        "earnedCoins" to earned,
                        "retainedCoins" to retained,
                        "timestamp" to System.currentTimeMillis()
                    )
                ).await()
        } catch (e: Exception) {
            Log.e("SessionCoinTracker", "Failed to log session coins", e)
        }
    }

    suspend fun fetchSessionCoins(sessionId: String): Pair<Int, Int> {
        val uid = auth.currentUser?.uid ?: return 0 to 0

        return try {
            val doc = db.collection("session_ledger").document("\-\").get().await()
            val earned = doc.getLong("earnedCoins")?.toInt() ?: 0
            val retained = doc.getLong("retainedCoins")?.toInt() ?: 0
            earned to retained
        } catch (e: Exception) {
            Log.e("SessionCoinTracker", "Fetch failed", e)
            0 to 0
        }
    }
}

