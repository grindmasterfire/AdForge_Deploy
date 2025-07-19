package com.fire.adforge.ui.raffle

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.SessionRaffleEntryViewModel

@Composable
fun SessionRaffleEntryScreen(sessionId: String) {
    val viewModel: SessionRaffleEntryViewModel = viewModel()
    val entries by viewModel.entries.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadEntries(sessionId)
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Raffle Entries for Session: \", style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(entries) { entry ->
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text("User: \")
                        Text("Tickets: \")
                        Text("Coins Used: \")
                    }
                }
            }
        }
    }
}
