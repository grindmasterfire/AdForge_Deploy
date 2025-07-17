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
import com.fire.adforge.viewmodel.RaffleStatsViewModel

@Composable
fun RaffleStatsScreen(vm: RaffleStatsViewModel = viewModel()) {
    val stats = vm.stats.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text("📈 Raffle Stats Dashboard", style = MaterialTheme.typography.headlineMedium)

        stats.value.forEach { stat ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text("🎟️ Raffle ID: ")
                    Text("🧾 Entries: ")
                    Text("🏅 Winners: ")
                    Text("✅ Verified Claims: ")
                    Text("📊 Claim Rate: %")
                }
            }
        }
    }
}

