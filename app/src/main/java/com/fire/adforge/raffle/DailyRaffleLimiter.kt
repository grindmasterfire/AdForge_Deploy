package com.fire.adforge.raffle

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import java.text.SimpleDateFormat
import java.util.*

object DailyRaffleLimiter {

    private val db = FirebaseFirestore.getInstance()
    private val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    suspend fun getDailyEntryCount(userId: String, raffleId: String): Int {
        return try {
            val today = sdf.format(Date())
            val snapshot = db.collection("raffle_entry_caps")
                .document("\-\-\")
                .get().await()
            snapshot.getLong("count")?.toInt() ?: 0
        } catch (e: Exception) {
            Log.e("DailyRaffleLimiter", "Fetch failed", e)
            0
        }
    }

    suspend fun incrementEntry(userId: String, raffleId: String) {
        try {
            val today = sdf.format(Date())
            val docId = "\-\-\"
            val ref = db.collection("raffle_entry_caps").document(docId)
            db.runTransaction { tx ->
                val snapshot = tx.get(ref)
                val current = snapshot.getLong("count") ?: 0
                tx.set(ref, mapOf("count" to current + 1))
            }.await()
        } catch (e: Exception) {
            Log.e("DailyRaffleLimiter", "Increment failed", e)
        }
    }

    suspend fun isAtLimit(userId: String, raffleId: String, cap: Int = 100): Boolean {
        val current = getDailyEntryCount(userId, raffleId)
        return current >= cap
    }
}
