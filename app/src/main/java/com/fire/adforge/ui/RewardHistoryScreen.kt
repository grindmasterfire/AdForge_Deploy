package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.RewardHistoryViewModel
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun RewardHistoryScreen(vm: RewardHistoryViewModel = viewModel()) {
    val rewards = vm.rewards.collectAsState()
    val formatter = remember { SimpleDateFormat("MMM dd, yyyy - HH:mm", Locale.getDefault()) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("🏆 Reward History", style = MaterialTheme.typography.headlineMedium)

        rewards.value.forEach { entry ->
            val formattedTime = formatter.format(Date(entry.timestamp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text("🎟️ Raffle: ", style = MaterialTheme.typography.bodyLarge)
                    Text("🕒 Won: ")
                    Text("💰 Coins: ")
                }
            }
        }
    }
}
