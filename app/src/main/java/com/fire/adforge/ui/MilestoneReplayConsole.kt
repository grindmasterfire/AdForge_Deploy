package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun MilestoneReplayConsole(offerId: String) {
    val db = FirebaseFirestore.getInstance()
    var entries by remember { mutableStateOf(listOf<String>()) }

    LaunchedEffect(Unit) {
        db.collection("milestones")
            .document(offerId)
            .collection("logs")
            .get().addOnSuccessListener { snapshot ->
                entries = snapshot.documents.mapNotNull {
                    val time = it.getTimestamp("timestamp")?.toDate()
                    val coins = it.getLong("coinsSpent")?.toInt() ?: 0
                    val user = it.getString("userId") ?: "unknown"
                    val formatted = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(time ?: Date())
                    "[$formatted] $user spent $coins coins"
                }
            }
    }

    Column(Modifier.fillMaxSize().padding(20.dp)) {
        Text("Milestone Replay Logs", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(8.dp))
        LazyColumn {
            items(entries) { line ->
                Text(line)
            }
        }
    }
}
