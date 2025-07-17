package com.fire.adforge.ui

import androidx.compose.runtime.*
import androidx.compose.material.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.ui.unit.dp
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun FireVaultScreen() {
    val db = FirebaseFirestore.getInstance()
    var entries by remember { mutableStateOf(listOf<Map<String, Any>>()) }

    LaunchedEffect(Unit) {
        val snapshot = db.collection("ledger")
            .document("fire")
            .collection("earnings")
            .get().await()
        entries = snapshot.documents.mapNotNull { it.data }
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("🔥 Fire’s Command Earnings", style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn {
            items(entries) { entry ->
                val date = Date(entry["timestamp"] as Long)
                val formatted = SimpleDateFormat("MMM dd yyyy, HH:mm", Locale.getDefault()).format(date)
                Text("• Raffle:  | Type: ")
                Text("→ FireCut:  coins on ")
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}
