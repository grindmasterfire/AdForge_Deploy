import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.util

import com.google.firebase.firestore.FirebaseFirestore

fun submitClanRaffleEntry(userId: String, clanId: String, onComplete: (Boolean) -> Unit) {
    val db = FirebaseFirestore.getInstance()
    val entry = mapOf(
        "userId" to userId,
        "clanId" to clanId,
        "timestamp" to System.currentTimeMillis()
    )

    db.collection("clanRaffleEntries")
        .add(entry)
        .addOnSuccessListener { onComplete(true) }
        .addOnFailureListener { onComplete(false) }
}

