package com.fire.adforge.ui.raffle

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.ClanRaffleViewModel
import com.fire.adforge.raffles.ClanRaffleManager
import kotlinx.coroutines.*

@Composable
fun ClanRaffleEntryScreen(clanId: String, raffleId: String, userId: String, type: String) {
    val vm: ClanRaffleViewModel = viewModel()
    val entrySuccess by vm.entrySuccess.collectAsState()

    Column(Modifier.fillMaxSize().padding(24.dp)) {
        Text("Raffle: ", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))
        Button(onClick = {
            CoroutineScope(Dispatchers.IO).launch {
                val success = ClanRaffleManager.enterClanRaffle(userId, clanId, raffleId, type)
                vm.entrySuccess.value = success
            }
        }) {
            Text("Submit Entry")
        }
        Spacer(Modifier.height(24.dp))
        when (entrySuccess) {
            true -> Text(" Entry successful", color = MaterialTheme.colorScheme.primary)
            false -> Text(" Entry failed", color = MaterialTheme.colorScheme.error)
            else -> {}
        }
    }
}
