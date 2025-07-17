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

@Composable
fun AutogrindStatus(crewId: String) {
    val db = FirebaseFirestore.getInstance()
    var activeCount by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        db.collection("crews").document(crewId)
            .collection("grind")
            .addSnapshotListener { snapshot, _ ->
                activeCount = snapshot?.documents?.count() ?: 0
            }
    }

    Column(modifier = Modifier.fillMaxWidth().padding(12.dp)) {
        Text("Active Grinders: $activeCount", style = MaterialTheme.typography.titleMedium)
    }
}

