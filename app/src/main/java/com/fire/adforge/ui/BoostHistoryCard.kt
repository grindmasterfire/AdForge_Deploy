package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fire.adforge.viewmodel.MilestoneLogViewModel
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun BoostHistoryCard(vm: MilestoneLogViewModel) {
    val log by vm.boostLog.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Recent Milestone Boost", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))

        if (log != null) {
            val date = SimpleDateFormat("MMM dd, HH:mm", Locale.getDefault())
                .format(Date(log!!.timestamp))

            Text("Spent: ${log!!.coinsSpent} coins")
            Text("When: $date")
            Text("Source: ${log!!.source}")
        } else {
            Text("No boost history yet.")
        }
    }
}
