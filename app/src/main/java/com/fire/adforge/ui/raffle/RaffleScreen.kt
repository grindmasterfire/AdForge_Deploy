package com.fire.adforge.ui.raffle

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fire.adforge.viewmodel.RaffleViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun RaffleScreen(vm: RaffleViewModel = viewModel()) {
    val status by vm.raffleStatus.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Raffle Center", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { vm.enterRaffle() }) {
            Text("Enter Raffle")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text("Status: \")
    }
}
