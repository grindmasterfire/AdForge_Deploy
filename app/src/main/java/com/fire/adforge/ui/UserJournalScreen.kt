package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.UserJournalViewModel
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun UserJournalScreen(vm: UserJournalViewModel = viewModel()) {
    val raffles = vm.raffles.collectAsState()
    val formatter = remember { SimpleDateFormat("MMM dd, yyyy - HH:mm", Locale.getDefault()) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("🏅 My Raffle History", style = MaterialTheme.typography.headlineMedium)

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(raffles.value) { entry ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text("🎟️ Raffle: ")
                        entry.timestamp?.let {
                            Text("📅 Date: ")
                        }
                        entry.entryCount?.let {
                            Text("🧾 Entries: ")
                        }
                        entry.totalPaid?.let {
                            Text("💰 Paid:  coins")
                        }
                    }
                }
            }
        }
    }
}
