package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.CrewLeaderboardViewModel
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun CrewLeaderboardScreen(vm: CrewLeaderboardViewModel = viewModel()) {
    val scores = vm.scores.collectAsState()
    val formatter = remember { SimpleDateFormat("MMM dd, yyyy - HH:mm", Locale.getDefault()) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("🏆 Crew Raffle Leaderboard", style = MaterialTheme.typography.headlineMedium)

        scores.value.forEachIndexed { index, score ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text("👑 Rank: ")
                    Text("🪪 Crew ID: ")
                    Text("💰 Coins: ")
                    Text("👥 Active Users: ")
                    Text("🕒 Last Updated: ")
                }
            }
        }
    }
}
