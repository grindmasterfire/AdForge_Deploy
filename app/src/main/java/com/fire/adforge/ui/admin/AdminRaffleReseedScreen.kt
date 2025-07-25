package com.fire.adforge.ui.admin

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.RaffleReseedViewModel

@Composable
fun AdminRaffleReseedScreen() {
    val vm: RaffleReseedViewModel = viewModel()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(" Admin Raffle Reseed", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = vm.raffleId.collectAsState().value,
            onValueChange = { vm.raffleId.value = it },
            label = { Text("Raffle ID") }
        )

        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = vm.raffleType.collectAsState().value,
            onValueChange = { vm.raffleType.value = it },
            label = { Text("Raffle Type (session, crew, clan, etc)") }
        )

        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = vm.overrideCode.collectAsState().value,
            onValueChange = { vm.overrideCode.value = it },
            label = { Text("Commander Override Code") }
        )

        Spacer(Modifier.height(16.dp))
        Button(onClick = { vm.reseed() }) {
            Text("Force Clear Raffle Entries")
        }

        Spacer(Modifier.height(12.dp))
        Text(vm.statusMessage.collectAsState().value)
    }
}
