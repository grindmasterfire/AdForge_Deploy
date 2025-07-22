package com.fire.adforge.ui.launch

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PlayStorePrepScreen() {
    var isReady by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
        Text("AdForge Alpha Launch Checklist", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Text("- Legal Screens ")
        Text("- AMOE Enabled ")
        Text("- Breadloop + Offerwalls ")
        Text("- Firebase Integrated ")
        Text("- Splash & Branding ")
        Text("- Wallet + Cashouts ")
        Text("- Social Walls + Crews ")

        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { isReady = true }) {
            Text("Mark Ready for Play Store")
        }

        if (isReady) {
            Spacer(modifier = Modifier.height(12.dp))
            Text(" App flagged as ready for Play Store submission.", color = MaterialTheme.colorScheme.primary)
        }
    }
}
