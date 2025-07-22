package com.fire.adforge.ui.special

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CipherBotWallScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(" CipherBot Wall", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        Text("\"sudo rights are earned, not given.\"", style = MaterialTheme.typography.bodyLarge)
        Text("\"the raffle is poppin  check in or cash out.\"", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(12.dp))

        Text(" Activity Feed:", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(" CipherBot auto-deployed raffle trigger at 2:36 PM")
        Text(" Badge announcement: Survivor of 21-Day Grind issued")
        Text(" Quote of the Day injected: Hotbox the leaderboard")

        Spacer(modifier = Modifier.height(16.dp))
        Text(" Party Slogan:", style = MaterialTheme.typography.titleMedium)
        Text(" Hotbox his page next weekend. BYOCloud.")
    }
}
