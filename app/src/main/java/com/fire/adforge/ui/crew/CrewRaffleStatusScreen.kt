import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui.crew

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.CrewRaffleViewModel

@Composable
fun CrewRaffleStatusScreen(vm: CrewRaffleViewModel = viewModel()) {
    val ticketMap by vm.crewTicketMap.collectAsState()
    val coinMap by vm.coinWeightMap.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Crew Raffle Status", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        ticketMap.forEach { (id, count) ->
            Text("• id: count ticket(s)", style = MaterialTheme.typography.bodyLarge)
        }

        Spacer(modifier = Modifier.height(24.dp))`r`n`r`n        Button(onClick = { vm.simulateBoost("Crew Phoenix", 150) }) { Text("🔥 Boost Crew Phoenix +150") }

        Button(onClick = { vm.syncCrewStatus() }) {
            Text("Refresh Status")
        }
    }
}






