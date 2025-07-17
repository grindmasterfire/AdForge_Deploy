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
import com.fire.adforge.viewmodel.ClanRaffleViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ClanRaffleResultsScreen(
    clanId: String,
    raffleId: String,
    vm: ClanRaffleViewModel = viewModel()
) {
    val winner = remember { mutableStateOf("Loading...") }
    val top5 = remember { mutableStateOf(listOf<String>()) }

    LaunchedEffect(Unit) {
        vm.loadResults(clanId, raffleId) { win, top ->
            winner.value = win
            top5.value = top
        }
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text("🎉 Clan Raffle Results", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        Text("🏆 Winner: ")
        Spacer(modifier = Modifier.height(12.dp))
        Text("Top 5 Entrants:")

        top5.value.forEachIndexed { i, user ->
            Text(". ")
        }
    }
}

