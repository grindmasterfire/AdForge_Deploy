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
import com.fire.adforge.viewmodel.CrewPrizeTierViewModel

@Composable
fun CrewPrizeTierScreen(vm: CrewPrizeTierViewModel = viewModel()) {
    val prizes = vm.prizes.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text("🎖️ Crew Prize Tiers – July 2025", style = MaterialTheme.typography.headlineMedium)

        prizes.value.forEach { prize ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text("🏆 Rank: ")
                    Text("🪪 Crew: ")
                    Text("💰 Reward:  coins")
                    Text("👥 Per Member:  coins")
                }
            }
        }
    }
}

