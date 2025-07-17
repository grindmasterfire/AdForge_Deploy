package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.RaffleViewModel
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun RaffleViewerScreen(viewModel: RaffleViewModel = viewModel()) {
    val raffles by viewModel.raffles.collectAsState()
    val formatter = remember { SimpleDateFormat("MM/dd HH:mm", Locale.getDefault()) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("🎁 Raffles Available", style = MaterialTheme.typography.headlineSmall)

        raffles.forEach { raffle ->
            Card(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(raffle.name, style = MaterialTheme.typography.titleLarge)
                    Text("Ends: \")
                    Text("Entries: \ / \")

                    Button(
                        onClick = { viewModel.enterRaffle(raffle.id, "currentUserId") },
                        enabled = raffle.entries < raffle.entryCap
                    ) {
                        Text("Enter Raffle")
                    }
                }
            }
        }
    }
}
