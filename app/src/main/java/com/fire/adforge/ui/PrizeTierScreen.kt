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
import com.fire.adforge.viewmodel.PrizeTierViewModel

@Composable
fun PrizeTierScreen(vm: PrizeTierViewModel = viewModel()) {
    val tiers = vm.tiers.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text("🎖️ Prize Tier Results", style = MaterialTheme.typography.headlineMedium)

        tiers.value.forEach { tier ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text("🏅 Tier: ", style = MaterialTheme.typography.titleLarge)
                    Text("💰 Prize:  coins")

                    Spacer(modifier = Modifier.height(6.dp))
                    tier.winners.forEach {
                        Text("👤 Winner: ")
                    }
                }
            }
        }
    }
}

