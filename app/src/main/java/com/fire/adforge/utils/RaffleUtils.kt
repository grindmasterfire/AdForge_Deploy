import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.utils

import com.fire.adforge.models.RaffleEntry
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

object RaffleUtils {

    suspend fun getVisibleRaffles(userClanId: String?): List<RaffleEntry> {
        val db = FirebaseFirestore.getInstance()
        val snap = db.collection("raffles").get().await()

        return snap.documents.mapNotNull { it.toObject(RaffleEntry::class.java) }.filter { raffle ->
            when (raffle.scope) {
                "global" -> true
                "clan" -> raffle.clanId != null && raffle.clanId == userClanId
                else -> false
            }
        }
    }
}

