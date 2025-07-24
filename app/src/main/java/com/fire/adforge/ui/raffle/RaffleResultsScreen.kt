package com.fire.adforge.ui.raffle

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.RaffleResultsViewModel

@Composable
fun RaffleResultsScreen() {
    val vm: RaffleResultsViewModel = viewModel()
    val results by vm.raffleResults.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Raffle Results Timeline", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(12.dp))
        LazyColumn {
            items(results) { result ->
                Card(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text("Date: ")
                        Text("Raffle ID: ")
                        Text("Ticket Type: ")
                        Text("Place: ")
                        Text("Coins Won: ")
                    }
                }
            }
        }
    }
}
