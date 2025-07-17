import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fire.adforge.viewmodel.CrewResultsViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CrewResultsScreen(vm: CrewResultsViewModel = viewModel()) {
    val winner by vm.winner.collectAsState()
    val runnerUps by vm.runnerUps.collectAsState()
    val topPlayers by vm.topPlayers.collectAsState()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text("🏆 Final Results", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(12.dp))

        Text("Winning Crew: \", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))

        Text("Runner-Ups:", style = MaterialTheme.typography.titleMedium)
        runnerUps.forEach { Text("• \") }

        Spacer(modifier = Modifier.height(12.dp))
        Text("Top Players:", style = MaterialTheme.typography.titleMedium)
        topPlayers.forEach { Text("• \") }
    }
}

