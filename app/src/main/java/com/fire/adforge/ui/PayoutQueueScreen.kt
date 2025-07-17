import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.PayoutQueueViewModel

@Composable
fun PayoutQueueScreen(vm: PayoutQueueViewModel = viewModel()) {
    val queue = vm.queue.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text("💸 Payout Queue (Admin View)", style = MaterialTheme.typography.headlineMedium)

        queue.value.forEach { payout ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text("👤 User: ")
                    Text("🎟️ Raffle: ")
                    Text("💰 Coins: ")
                    Text("📦 Status: ")

                    if (payout.status != "completed") {
                        Spacer(Modifier.height(8.dp))
                        Button(onClick = { vm.markAsPaid(payout.userId) }) {
                            Text("✅ Mark as Paid")
                        }
                    }
                }
            }
        }
    }
}

