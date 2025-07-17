import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.util

import com.google.firebase.firestore.FirebaseFirestore

fun pickClanRaffleWinner(clanId: String, onResult: (String?) -> Unit) {
    val db = FirebaseFirestore.getInstance()

    db.collection("clanRaffleEntries")
        .whereEqualTo("clanId", clanId)
        .get()
        .addOnSuccessListener { entries ->
            if (entries.isEmpty) {
                onResult(null)
                return@addOnSuccessListener
            }

            val randomIndex = (0 until entries.size()).random()
            val winnerDoc = entries.documents[randomIndex]
            val userId = winnerDoc.getString("userId")

            if (userId != null) {
                db.collection("clanRaffleWinners")
                    .document(clanId)
                    .set(mapOf("winner" to userId))
                    .addOnSuccessListener { onResult(userId) }
                    .addOnFailureListener { onResult(null) }
            } else {
                onResult(null)
            }
        }
        .addOnFailureListener { onResult(null) }
}

