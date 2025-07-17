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
import com.fire.adforge.viewmodel.RaffleTrackerViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CrewRaffleStatusScreen(vm: RaffleTrackerViewModel = viewModel()) {
    val title by vm.raffleTitle.collectAsState()
    val countdown by vm.countdown.collectAsState()
    var claimStatus by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Crew Raffle Tracker", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(12.dp))

        Text("Raffle: \", style = MaterialTheme.typography.bodyLarge)
        Text("Time Remaining: \", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {
            vm.submitClaim()
            claimStatus = "Claim submitted!"
        }) {
            Text("Submit Claim")
        }

        Spacer(modifier = Modifier.height(12.dp))
        Text(claimStatus)
    }
}

