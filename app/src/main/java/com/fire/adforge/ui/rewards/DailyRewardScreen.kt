package com.fire.adforge.ui.rewards

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.DailyRewardViewModel

@Composable
fun DailyRewardScreen(currentUserId: String) {
    val viewModel: DailyRewardViewModel = viewModel()
    val hasClaimed by viewModel.hasClaimed.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.checkIfClaimed(currentUserId)
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Daily Reward", style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.height(8.dp))

        if (hasClaimed) {
            Text("✅ You've already claimed today's reward.")
        } else {
            Button(onClick = {
                viewModel.claimReward(currentUserId) {}
            }) {
                Text("Claim 50 Coins")
            }
        }
    }
}
