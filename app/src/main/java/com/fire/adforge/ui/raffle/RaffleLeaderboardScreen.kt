package com.fire.adforge.ui.raffle

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class RaffleChampion(val userId: String, val coinsWon: Int, val rafflesWon: Int)

@Composable
fun RaffleLeaderboardScreen(champions: List<RaffleChampion>) {
    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("Top Raffle Champions", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(12.dp))
        LazyColumn {
            champions.sortedByDescending { it.coinsWon }.forEachIndexed { index, champ ->
                item {
                    Card(Modifier.fillMaxWidth().padding(vertical = 6.dp)) {
                        Column(Modifier.padding(16.dp)) {
                            Text("#: ", style = MaterialTheme.typography.bodyLarge)
                            Text("Coins Won: ", style = MaterialTheme.typography.bodyMedium)
                            Text("Raffles Won: ", style = MaterialTheme.typography.bodySmall)
                        }
                    }
                }
            }
        }
    }
}
