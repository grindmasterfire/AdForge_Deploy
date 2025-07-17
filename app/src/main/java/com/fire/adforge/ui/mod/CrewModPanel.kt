package com.fire.adforge.ui.mod

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CrewModPanel() {
    var flaggedUser by remember { mutableStateOf("") }
    var reportReason by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
        Text("🛡️ Crew Moderator Panel", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = flaggedUser,
            onValueChange = { flaggedUser = it },
            label = { Text("User ID to review") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = reportReason,
            onValueChange = { reportReason = it },
            label = { Text("Report Notes / Reason") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))

        Button(onClick = {
            // TODO: Hook with ReportManager backend
        }) {
            Text("🚨 Submit Review Flag")
        }
    }
}
