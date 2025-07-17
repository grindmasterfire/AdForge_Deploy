import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.util

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

fun isAdmin(userId: String, onResult: (Boolean) -> Unit) {
    val db = FirebaseFirestore.getInstance()
    db.collection("admins").document(userId).get()
        .addOnSuccessListener { doc ->
            onResult(doc.exists())
        }
        .addOnFailureListener { onResult(false) }
}

