package com.fire.adforge.ui.special

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CipherBotWallScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(" CipherBots Wall", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(8.dp))
        Text("CipherBot is just this guy, you know... with sudo rights.")
        Text("\"He always knows which raffle is poppin.\"")
        Spacer(modifier = Modifier.height(12.dp))

        Text(" Thought of the Day:", style = MaterialTheme.typography.titleMedium)
        Text("Observe. Moderate. Vaporize Spam.")

        Spacer(modifier = Modifier.height(12.dp))
        Text(" Recent Activity Log")
        Text(" Flagged 3 spam links in #General")
        Text(" Issued 1 mute to user XxCoinHustlerxX")
        Text(" Pinned crew badge achievement for user GrindLord420")

        Spacer(modifier = Modifier.height(12.dp))
        Text(" Hotbox Party Next Weekend. BYOCloud.")
    }
}
