package com.fire.adforge.ui.wallet

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fire.adforge.engine.SponsorEngine

@Composable
fun EarningSummaryScreen(userId: String) {
    val summaryItems = remember { EarningSummaryBinder.summarize(userId) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Earning Summary") })
        }
    ) { padding ->
        LazyColumn(modifier = Modifier
            .padding(padding)
            .fillMaxSize()
            .padding(16.dp)) {
            items(summaryItems) { item ->
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp)) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Category: ", style = MaterialTheme.typography.titleMedium)
                        Text("Total Coins: ")
                    }
                }
            }
        }
    }
}
