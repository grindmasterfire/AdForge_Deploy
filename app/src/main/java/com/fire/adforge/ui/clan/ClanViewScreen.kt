package com.fire.adforge.ui.clan

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.ClanViewModel

@Composable
fun ClanViewScreen(viewModel: ClanViewModel = viewModel()) {
    val clanState by viewModel.clanData.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text("Your Clan", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(20.dp))

        Text("Clan Name: ")
        Spacer(modifier = Modifier.height(8.dp))

        Text("Number of Crews: ")
        Spacer(modifier = Modifier.height(16.dp))

        if ((clanState?.crewIds?.size ?: 0) < 4) {
            Text(" Clan will disband soon! Minimum is 4 crews.", color = MaterialTheme.colorScheme.error)
        } else {
            Text("Clan is active", color = MaterialTheme.colorScheme.primary)
        }

        Spacer(modifier = Modifier.height(20.dp))
        Text("Crews in Clan:")
        clanState?.crewIds?.forEach { id ->
            Text(" ")
        }
    }
}
