package com.fire.adforge.ui.claims

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.PayoutQueueViewModel

@Composable
fun PayoutHistoryScreen(currentUserId: String) {
    val viewModel: PayoutQueueViewModel = viewModel()
    val queue by viewModel.queue.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchPayoutQueue()
    }

    val userHistory = queue.filter { it.userId == currentUserId }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Payout History", style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(userHistory) { payout ->
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text("Amount: \")
                        Text("Method: \")
                        Text("Status: \")
                    }
                }
            }
        }
    }
}
