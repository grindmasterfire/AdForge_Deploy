package com.fire.adforge.ui.raffle

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.ClanRaffleViewModel
import com.fire.adforge.raffles.ClanRaffleMacroEngine
import kotlinx.coroutines.*

@Composable
fun ClanRaffleResultScreen(clanId: String, raffleId: String) {
    val vm: ClanRaffleViewModel = viewModel()
    val winner by vm.resultWinner.collectAsState()

    val raffleType = "TWENTY_ONE_JACKPOT"
    val rewardAmount = 50

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Clan Raffle Result", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(16.dp))

        Button(onClick = {
            CoroutineScope(Dispatchers.IO).launch {
                val success = ClanRaffleMacroEngine.runFullDrawCycle(
                    clanId = clanId,
                    raffleId = raffleId,
                    raffleType = raffleType,
                    rewardAmount = rewardAmount
                )
                if (success) {
                    vm.resultWinner.value = "Rewarded  coins!"
                } else {
                    vm.resultWinner.value = " Raffle draw or payout failed"
                }
            }
        }) {
            Text("Draw + Reward")
        }

        Spacer(Modifier.height(24.dp))
        winner?.let {
            Card(
                modifier = Modifier.fillMaxWidth().padding(12.dp),
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer)
            ) {
                Box(Modifier.fillMaxWidth().padding(24.dp)) {
                    Text(it, style = MaterialTheme.typography.titleLarge)
                }
            }
        }
    }
}
