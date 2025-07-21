package com.fire.adforge.ui.wallet

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fire.adforge.backend.SponsorAttributionLedger

@Composable
fun OfferwallAttributionScreen(userId: String) {
    val entries = remember { SponsorAttributionLedger.getAll().filter { it.userId == userId } }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Sponsor Attribution") })
        }
    ) { padding ->
        LazyColumn(modifier = Modifier
            .padding(padding)
            .fillMaxSize()
            .padding(16.dp)) {
            items(entries) { entry ->
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp)) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Sponsor: ", style = MaterialTheme.typography.titleMedium)
                        Text("Category: ")
                        Text("Coins Earned: ")
                        Text("Timestamp: ")
                    }
                }
            }
        }
    }
}
