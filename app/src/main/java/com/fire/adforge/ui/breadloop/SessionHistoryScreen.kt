package com.fire.adforge.ui.breadloop

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.BreadloopHistoryViewModel

@Composable
fun SessionHistoryScreen() {
    val vm: BreadloopHistoryViewModel = viewModel()
    val sessions by vm.sessionHistory.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Session History", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(12.dp))
        LazyColumn {
            items(sessions) { session ->
                Card(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text("Date: ")
                        Text("Liveness Triggered: s")
                        Text("AMOE Ticket: ")
                        Text("Bonus Tickets: ")
                    }
                }
            }
        }
    }
}
