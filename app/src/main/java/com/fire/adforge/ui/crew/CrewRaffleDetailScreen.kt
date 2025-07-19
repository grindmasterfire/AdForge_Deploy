package com.fire.adforge.ui.crew

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.CrewRaffleLoaderViewModel

@Composable
fun CrewRaffleDetailScreen(crewName: String) {
    val viewModel: CrewRaffleLoaderViewModel = viewModel()
    val raffles by viewModel.raffles.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchCrewRaffles()
    }

    val raffle = raffles.find { it.crewName == crewName }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Crew Raffle Details", style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.height(8.dp))

        raffle?.let {
            Text("Crew Name: \")
            Text("Total Tickets: \")
            Text("Top Contributor: \")
        } ?: Text("Raffle not found.")
    }
}
