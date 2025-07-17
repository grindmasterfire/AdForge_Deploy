import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import androidx.compose.runtime.*
import androidx.compose.material.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.RaffleHubViewModel

@Composable
fun RaffleHubScreen(userId: String, navController: androidx.navigation.NavHostController) {
    val vm: RaffleHubViewModel = viewModel()
    val crewOk by vm.crewEligible.collectAsState()
    val clanOk by vm.clanEligible.collectAsState()

    LaunchedEffect(Unit) {
        vm.checkCrewAndClanStatus(userId)
    }

    Column {
        Text("🎟️ Raffle Hub", style = MaterialTheme.typography.h5)

        Button(onClick = { navController.navigate("crewRaffle") }) {
            Text("Join Crew Raffle")
        }

        if (crewOk) {
            Button(onClick = { navController.navigate("crewPrivateRaffle") }) {
                Text("Enter Private Crew Raffle")
            }
        }

        Button(onClick = { navController.navigate("clanRaffle") }) {
            Text("Join Clan Raffle")
        }

        if (clanOk) {
            Button(onClick = { navController.navigate("clanPrivateRaffle") }) {
                Text("Enter Private Clan Raffle")
            }
        }
    }
}

