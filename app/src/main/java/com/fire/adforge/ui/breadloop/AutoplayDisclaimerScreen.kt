package com.fire.adforge.ui.breadloop

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.BreadloopViewModel

@Composable
fun AutoplayDisclaimerScreen(onAccept: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Before using the autoplay feature, please read the following:",
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = """
 Autoplay must be played with audible sound or headphones.
 The liveness moment pauses playback to confirm session presence.
 Raffle tickets are awarded through sweepstakes mechanics.

Legal Disclosures:
 Must be 18+ to enter
 Void where prohibited
 Alternate means of entry always available
 Raffle odds are based on total number of entries
 AMOE tickets hold no monetary value
""".trimIndent(),
            color = Color.DarkGray
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = onAccept) {
            Text("I Understand & Accept")
        }
    }
}
