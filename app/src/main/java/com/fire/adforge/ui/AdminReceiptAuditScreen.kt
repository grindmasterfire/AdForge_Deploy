package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.AdminReceiptAuditViewModel
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun AdminReceiptAuditScreen(vm: AdminReceiptAuditViewModel = viewModel()) {
    val receipts = vm.receipts.collectAsState()
    val formatter = remember { SimpleDateFormat("MMM dd, yyyy - HH:mm", Locale.getDefault()) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("🗃️ Admin Reward Receipt Audit", style = MaterialTheme.typography.headlineMedium)

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(receipts.value) { receipt ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text("👤 User: ")
                        Text("🎟️ Raffle ID: ")
                        Text("💰 Amount: ")
                        Text("📦 Status: ")
                        receipt.timestamp?.let {
                            Text("🕒 Verified: ")
                        }
                    }
                }
            }
        }
    }
}
