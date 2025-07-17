package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.RaffleJournalViewModel
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun RaffleJournalScreen(vm: RaffleJournalViewModel = viewModel()) {
    val journal = vm.journal.collectAsState()
    val formatter = remember { SimpleDateFormat("MMM dd, yyyy - HH:mm", Locale.getDefault()) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("📖 Raffle Journal Archive", style = MaterialTheme.typography.headlineMedium)

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(journal.value) { record ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text("🎟️ Raffle ID: ")
                        Text("📅 Date: ")
                        Text("🧾 Entries: ")
                        Text("💰 Total Paid:  coins")
                    }
                }
            }
        }
    }
}
