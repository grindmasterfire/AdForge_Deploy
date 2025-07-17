import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun AdminRaffleMonitor(raffleType: String) {
    val db = FirebaseFirestore.getInstance()
    var entries by remember { mutableStateOf(listOf<String>()) }

    LaunchedEffect(Unit) {
        db.collection("raffles")
            .whereEqualTo("type", raffleType)
            .get().addOnSuccessListener { snapshot ->
                entries = snapshot.documents.mapNotNull { it.id }
            }
    }

    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("Raffle Monitor – $raffleType", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(8.dp))
        LazyColumn {
            items(entries) { id ->
                Text("Raffle ID: $id")
            }
        }
    }
}

