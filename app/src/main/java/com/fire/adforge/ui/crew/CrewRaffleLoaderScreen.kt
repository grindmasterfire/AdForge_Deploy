package com.fire.adforge.ui.crew

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.CrewRaffleLoaderViewModel

@Composable
fun CrewRaffleLoaderScreen() {
    val viewModel: CrewRaffleLoaderViewModel = viewModel()
    val raffles by viewModel.raffles.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchCrewRaffles()
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Crew Raffles", style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(raffles) { raffle ->
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text("Crew: \")
                        Text("Total Tickets: \")
                        Text("Top Contributor: \")
                    }
                }
            }
        }
    }
}
