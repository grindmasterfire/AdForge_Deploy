package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.CoinHistoryViewModel
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun CoinHistoryScreen(vm: CoinHistoryViewModel = viewModel()) {
    val history = vm.history.collectAsState()
    val formatter = remember { SimpleDateFormat("MMM dd, yyyy - HH:mm", Locale.getDefault()) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("📜 Coin Earning History", style = MaterialTheme.typography.headlineMedium)

        history.value.forEach { entry ->
            val formattedTime = formatter.format(Date(entry.timestamp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text("📅 Date: ")
                    Text("💰 Amount:  coins")
                    Text("📦 Type: ")
                    entry.source?.let { Text("🔗 Source: ") }
                }
            }
        }
    }
}
