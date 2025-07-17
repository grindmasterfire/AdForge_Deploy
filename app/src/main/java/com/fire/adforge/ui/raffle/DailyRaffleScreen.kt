import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui.raffle

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.DailyRaffleViewModel

@Composable
fun DailyRaffleScreen(vm: DailyRaffleViewModel = viewModel()) {
    var purchaseAmount by remember { mutableStateOf(\"\") }
    val ticketCount by vm.dailyTicketCount.collectAsState()
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Daily Raffle Tickets", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Tickets owned: ticketCount", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { vm.refreshTickets() }) {
            Text("Refresh Tickets")
        }
    }
}





