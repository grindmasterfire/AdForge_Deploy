package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fire.adforge.backend.CrewLeaderboardFetcher
import com.fire.adforge.model.CrewLeaderboard
import kotlinx.coroutines.*

@Composable
fun CrewLeaderboardScreen() {
    var crews by remember { mutableStateOf<List<CrewLeaderboard>>(emptyList()) }

    LaunchedEffect(Unit) {
        crews = withContext(Dispatchers.IO) {
            CrewLeaderboardFetcher.getLeaderboard()
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(20.dp)) {
        Text("🏆 Crew Leaderboard", style = MaterialTheme.typography.headlineLarge)
        Spacer(Modifier.height(16.dp))
        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(crews) { crew ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("# - ", style = MaterialTheme.typography.titleLarge)
                        Text("Members:  | Multiplier: x", style = MaterialTheme.typography.bodyMedium)
                        Text("Earnings:  coins", style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}
