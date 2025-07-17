import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.services

import com.google.firebase.firestore.FirebaseFirestore
import com.fire.adforge.engine.RaffleEngine

object FirebaseRaffleService {

    private val db = FirebaseFirestore.getInstance()

    fun monitorRaffle(raffleId: String, onResultReady: (Map<String, Double>) -> Unit) {
        val ref = db.collection("raffles").document(raffleId)
        ref.get().addOnSuccessListener { doc ->
            if (doc != null && doc.exists()) {
                val type = doc.getString("type") ?: return@addOnSuccessListener
                val entrants = doc.get("entrants") as? List<String> ?: emptyList()
                val startTime = doc.getLong("startTime") ?: 0L
                val ticketsSold = doc.getLong("ticketsSold")?.toInt() ?: 0

                val resolved = when (type) {
                    "capped", "uncapped" -> {
                        val end = RaffleEngine.handleDailyRaffle(type, ticketsSold, startTime)
                        if (end) mapOf("winner" to 1.0) else emptyMap()
                    }
                    else -> RaffleEngine.resolve21DayRaffle(type, entrants)
                }

                if (resolved.isNotEmpty()) {
                val payloads = resolved.map { (uid, pct) ->
                    mapOf(
                        "userId" to uid,
                        "percentOfPot" to pct,
                        "payoutCoins" to (pct * 10000).toLong()
                    )
                }
                ref.update("results", payloads)

                    onResultReady(resolved)
                }
            }
        }
    }
}

