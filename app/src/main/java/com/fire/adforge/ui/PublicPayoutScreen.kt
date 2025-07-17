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
import com.fire.adforge.viewmodel.PublicPayoutViewModel

@Composable
fun PublicPayoutScreen(vm: PublicPayoutViewModel = viewModel()) {
    val payouts = vm.payouts.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text("📢 Verified Rewards Paid Out", style = MaterialTheme.typography.headlineMedium)

        payouts.value.forEach { payout ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text("👤 User: ")
                    Text("🎟️ Raffle ID: ")
                    Text("💰 Paid:  coins")
                }
            }
        }
    }
}

