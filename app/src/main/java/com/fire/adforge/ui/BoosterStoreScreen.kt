package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.backend.BoosterWriter
import com.fire.adforge.model.BoosterOffer
import com.fire.adforge.viewmodel.CoinStateViewModel

@Composable
fun BoosterStoreScreen() {
    val coinViewModel: CoinStateViewModel = viewModel()
    val coinBalance = coinViewModel.coins.collectAsState().value
    var boosters = remember {
        mutableStateListOf(
            BoosterOffer("adgem_raid", "RAID Boost +5%", "AdGem", 50),
            BoosterOffer("pollfish_bonus", "Survey Bonus +10%", "Pollfish", 75)
        )
    }

    Column(modifier = Modifier.fillMaxSize().padding(20.dp)) {`n    val navController = rememberNavController()
        Text("⚡ Milestone Boosters", style = MaterialTheme.typography.headlineLarge)
        Spacer(Modifier.height(16.dp))
        Text("Balance:  coins", style = MaterialTheme.typography.bodyLarge)
        Spacer(Modifier.height(16.dp))
        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(boosters) { boost ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(boost.title, style = MaterialTheme.typography.titleMedium)
                        Text("Provider: ", style = MaterialTheme.typography.bodySmall)
                        Text("Cost:  coins", style = MaterialTheme.typography.bodySmall)
                        Button(
                            onClick = {
                                if (coinBalance >= boost.coinCost) {
                                    coinViewModel.apply {
                                        _coins.value -= boost.coinCost
                                    }
                                    BoosterWriter.logBoosterPurchase(boost)
                                }
                            }
                        ) {
                            Text("Buy Booster")
                        }
                    }
                }
            }
        }
    }
}
