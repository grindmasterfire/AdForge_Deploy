package com.adforge.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import com.adforge.raffle.RaffleType
import com.adforge.raffle.RaffleTypeSelector
import com.adforge.raffle.RaffleLogic
import com.adforge.raffle.RewardEngine

@Composable
fun RaffleScreen() {
    var selectedType by remember { mutableStateOf(RaffleType.WINNER_TAKES_ALL) }
    val logic = remember { RaffleLogic() }
    val rewardEngine = remember { RewardEngine() }

    var rewardOutput by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        RaffleTypeSelector(onTypeSelected = { selectedType = it })

        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = {
            rewardOutput = rewardEngine.calculateRewards(
                selectedType,
                totalPot = 10000,
                entrants = 500
            )
        }) {
            Text("Simulate Raffle")
        }

        Spacer(modifier = Modifier.height(12.dp))
        Text("Result: rewardOutput")
    }
}
