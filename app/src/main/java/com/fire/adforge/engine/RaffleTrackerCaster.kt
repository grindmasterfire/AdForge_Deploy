package com.fire.adforge.engine

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.Timestamp
import java.text.SimpleDateFormat
import java.util.*

object RaffleTrackerCaster {

    suspend fun postDailyRaffleStats() {
        val db = FirebaseFirestore.getInstance()
        val dailyRef = db.collection("raffles").document("daily_uncapped")

        dailyRef.get().addOnSuccessListener { doc ->
            val end = doc.getTimestamp("endTime")?.toDate()
            val entries = (doc.getLong("ticketCount") ?: 0).toInt()

            val timeLeft = end?.let {
                val diff = it.time - Date().time
                val minutes = (diff / 60000).coerceAtLeast(0)
                " min left"
            } ?: "unknown"

            val post = hashMapOf(
                "authorId" to "CipherBot",
                "text" to """
 DAILY RAFFLE WATCH
 Tickets: 
 Time Remaining: 
 Still time to win big. Grind it out.
""".trimIndent(),
                "timestamp" to Timestamp.now()
            )

            db.collection("cipher_wall").add(post)
        }
    }
}
