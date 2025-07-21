package com.fire.adforge.ui.raffle

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class RaffleEntry(val raffleId: String, val type: String, val date: String)

@Composable
fun RaffleHistoryScreen(userEntries: List<RaffleEntry>) {
    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("My Raffle Entries", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(12.dp))
        LazyColumn {
            items(userEntries.size) { index ->
                val entry = userEntries[index]
                Card(Modifier.fillMaxWidth().padding(vertical = 6.dp)) {
                    Column(Modifier.padding(16.dp)) {
                        Text("Raffle ID: ", style = MaterialTheme.typography.bodyLarge)
                        Text("Type: ", style = MaterialTheme.typography.bodyMedium)
                        Text("Date: ", style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
    }
}
