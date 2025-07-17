import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.delay

@Composable
fun SessionEngagementPulse(sessionId: String) {
    val db = FirebaseFirestore.getInstance()
    var watchers by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        while (true) {
            db.collection("autoplay")
                .document(sessionId)
                .collection("checkpoints")
                .get().addOnSuccessListener {
                    watchers = it.documents.size
                }
            delay(10000)
        }
    }

    Column(Modifier.fillMaxWidth().padding(16.dp)) {
        Text("Session Watchers: $watchers", style = MaterialTheme.typography.titleMedium)
    }
}

