package com.fire.adforge.ui.boosters

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.BoosterInventoryViewModel

@Composable
fun BoosterInventoryScreen(walletCoins: Int) {
    val vm: BoosterInventoryViewModel = viewModel()
    vm.updateWallet(walletCoins)

    val sponsorId by vm.sponsorId.collectAsState()
    val status by vm.status.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(" Milestone Boosters", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(16.dp))
        OutlinedTextField(
            value = sponsorId,
            onValueChange = { vm.setSponsor(it) },
            label = { Text("Sponsor Offer ID") }
        )
        Spacer(Modifier.height(16.dp))
        Button(onClick = { vm.activateBooster() }) {
            Text("Spend 100 Coins to Boost")
        }
        Spacer(Modifier.height(12.dp))
        Text("Wallet Coins: ")
        Text(status)
    }
}
