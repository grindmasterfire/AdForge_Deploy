import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fire.adforge.viewmodel.RaffleViewModel
import com.fire.adforge.model.demoRaffles

@Composable
fun RaffleScreen(navController: NavController, raffleId: String) {
    val vm = remember { RaffleViewModel() }
    val raffle = com.fire.adforge.model.RaffleRegistry.raffles.find { it.id == raffleId } ?: demoRaffles.last()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(text = raffle.name, style = MaterialTheme.typography.headlineMedium)
        Text(text = "Status: ")
        Text(text = "Tickets Owned: \")
        Text(text = "Entry Cost: \ coins")

        Button(onClick = { vm.tryEnterRaffle() }) {
            Text("Enter Raffle")
        }

        Button(onClick = { navController.navigate("raffleResult") }) {
            Text("Draw Raffle")
        }
    }
}

