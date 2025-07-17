package com.fire.adforge.ui.crew

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CrewLeaderboardScreen(crews: Map<String, Int>) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("⚔️ Crew Showdown Leaderboard", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(12.dp))
        crews.entries.sortedByDescending { it.value }.forEachIndexed { index, (crew, score) ->
            Text("\. \ — \ pts", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}
