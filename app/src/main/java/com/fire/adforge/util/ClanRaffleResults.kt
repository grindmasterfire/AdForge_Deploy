import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.util

import com.google.firebase.firestore.FirebaseFirestore

fun fetchClanRaffleResults(clanId: String, onResult: (Int, String?) -> Unit) {
    val db = FirebaseFirestore.getInstance()

    db.collection("clanRaffleEntries")
        .whereEqualTo("clanId", clanId)
        .get()
        .addOnSuccessListener { entries ->
            val count = entries.size()
            db.collection("clanRaffleWinners").document(clanId).get()
                .addOnSuccessListener { doc ->
                    val winner = doc.getString("winner")
                    onResult(count, winner)
                }
                .addOnFailureListener { onResult(count, null) }
        }
        .addOnFailureListener { onResult(0, null) }
}

