package com.fire.adforge.ui.admin

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FirebaseLiveMonitor() {
    Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
        Text("Firebase Live Monitor", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        Text(" Events per hour: 452")
        Text(" Authenticated users: 129")
        Text("  Crash reports: 0")
        Text(" Breadloop view rate: 92%")
        Text(" Raffle draw queue: clear")

        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { /* Placeholder: force log refresh */ }) {
            Text("Refresh Now")
        }
    }
}
