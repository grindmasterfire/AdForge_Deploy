package com.fire.adforge.ui.admin

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AdminLedgerViewScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
        Text("Platform Ledger Viewer", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        Text("- Total Coins Circulated: 92,360")
        Text("- Coins Held in Wallets: 38,211")
        Text("- Total Payouts Completed: \,210")
        Text("- Active Raffles: 6")
        Text("- Clans Formed: 8 | Crews: 47")
        Text("- System Uptime: 99.98%")

        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = { /* future action */ }) {
            Text("Export Snapshot")
        }
    }
}
