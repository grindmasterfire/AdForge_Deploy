package com.fire.adforge.ui.raffle

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CrewRaffleHubScreen(crews: List<String>, onRaffleSelect: (String, String) -> Unit) {
    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("Crew Raffles", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(16.dp))
        LazyColumn {
            crews.forEach { crewId ->
                item {
                    Text("Crew: ", style = MaterialTheme.typography.titleMedium)
                    Button(
                        onClick = { onRaffleSelect(crewId, "private") },
                        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
                    ) {
                        Text("Enter Private Raffle")
                    }
                    Button(
                        onClick = { onRaffleSelect(crewId, "public") },
                        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
                    ) {
                        Text("Enter Public Raffle")
                    }
                    Spacer(Modifier.height(12.dp))
                }
            }
        }
    }
}
