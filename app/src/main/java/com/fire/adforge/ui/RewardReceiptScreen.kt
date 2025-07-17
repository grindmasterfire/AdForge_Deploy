package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.RewardReceiptViewModel
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun RewardReceiptScreen(vm: RewardReceiptViewModel = viewModel()) {
    val receipts = vm.receipts.collectAsState()
    val formatter = remember { SimpleDateFormat("MMM dd, yyyy - HH:mm", Locale.getDefault()) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("🧾 Reward Receipt Summary", style = MaterialTheme.typography.headlineMedium)

        receipts.value.forEach { receipt ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text("🎟️ Raffle ID: ")
                    Text("💰 Amount:  coins")
                    Text("📦 Status: ")
                    receipt.timestamp?.let {
                        val formatted = formatter.format(Date(it))
                        Text("🕒 Verified On: ")
                    }
                }
            }
        }
    }
}
