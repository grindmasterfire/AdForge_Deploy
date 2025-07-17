import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.CrewPayoutViewModel

@Composable
fun CrewPayoutScreen(vm: CrewPayoutViewModel = viewModel()) {
    val crewPayouts = vm.crewPayouts.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text("🏴 Crew-Based Payout Totals", style = MaterialTheme.typography.headlineMedium)

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(crewPayouts.value) { crew ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text("🪪 Crew: ")
                        Text("💰 Total Paid:  coins")
                        Text("👥 Users Paid: ")
                        Text("📊 Avg Per User: ")
                    }
                }
            }
        }
    }
}

