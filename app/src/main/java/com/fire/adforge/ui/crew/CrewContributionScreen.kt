package com.fire.adforge.ui.crew

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.CrewGrindViewModel

@Composable
fun CrewContributionScreen() {
    val vm: CrewGrindViewModel = viewModel()
    val grindList by vm.crewGrind.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Crew Contribution Graph", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(12.dp))
        LazyColumn {
            items(grindList) { member ->
                Card(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text("User: ")
                        Text("Coins Earned: ")
                        Text("Eligible for Raffle: ")
                    }
                }
            }
        }
    }
}
