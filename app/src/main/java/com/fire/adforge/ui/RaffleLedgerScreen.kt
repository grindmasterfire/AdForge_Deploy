package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.RaffleLedgerViewModel
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun RaffleLedgerScreen(vm: RaffleLedgerViewModel = viewModel()) {
    val ledger = vm.ledger.collectAsState()
    val formatter = remember { SimpleDateFormat("MMM dd, yyyy - HH:mm", Locale.getDefault()) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("📊 Raffle Ledger", style = MaterialTheme.typography.headlineMedium)

        ledger.value.forEach { entry ->
            val formattedTime = formatter.format(Date(entry.timestamp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text("🎟️ Raffle: ")
                    Text("👤 Winner: ")
                    Text("🕒 Verified: ")
                    Text("💰 Coins: ")
                }
            }
        }
    }
}
