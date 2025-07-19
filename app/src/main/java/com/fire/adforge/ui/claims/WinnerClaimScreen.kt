package com.fire.adforge.ui.claims

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.WinnerClaimViewModel

@Composable
fun WinnerClaimScreen(currentUserId: String) {
    val viewModel: WinnerClaimViewModel = viewModel()
    val winners by viewModel.winners.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchWinners()
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Your Raffle Winnings", style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.height(8.dp))

        val userWin = winners.find { it.userId == currentUserId }

        if (userWin != null) {
            Text("Prize: \ coins")
            Spacer(modifier = Modifier.height(8.dp))
            if (!userWin.claimed) {
                Button(onClick = {
                    viewModel.markAsClaimed(currentUserId)
                }) {
                    Text("Claim Prize")
                }
            } else {
                Text("✅ Prize already claimed")
            }
        } else {
            Text("No winnings found.")
        }
    }
}
