import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import androidx.compose.runtime.*
import androidx.compose.material.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.ui.unit.dp
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

@Composable
fun FounderWallScreen() {
    val db = FirebaseFirestore.getInstance()
    var founders by remember { mutableStateOf(listOf<Map<String, Any>>()) }

    LaunchedEffect(Unit) {
        val snapshot = db.collection("users")
            .whereGreaterThan("founderRank", 0)
            .orderBy("founderRank")
            .limit(1000)
            .get().await()

        founders = snapshot.documents.mapNotNull { it.data }
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("🌟 The First 1000", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn {
            items(founders) { founder ->
                val rank = founder["founderRank"] ?: "-"
                val id = (founder["uid"] as? String)?.takeLast(6) ?: "user"
                Text("• # – ")
                Spacer(modifier = Modifier.height(6.dp))
            }
        }
    }
}

