import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.util

import com.google.firebase.firestore.FirebaseFirestore

fun validateClanMembership(userId: String, clanId: String, onResult: (Boolean) -> Unit) {
    val db = FirebaseFirestore.getInstance()
    db.collection("users").document(userId).get()
        .addOnSuccessListener {
            val userClanId = it.getString("clanId")
            onResult(userClanId == clanId)
        }
        .addOnFailureListener {
            onResult(false)
        }
}

