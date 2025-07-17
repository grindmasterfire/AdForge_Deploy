import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodels.RaffleViewModel

@Composable
fun RaffleResultScreen(vm: RaffleViewModel = viewModel()) {
    val resultMap by vm.raffleResults.collectAsState()
    val raffleType by vm.raffleType.collectAsState()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp)) {

        Text("🎉 Raffle Results", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        when (raffleType) {
            "jackpot" -> {
                val winner = resultMap.keys.firstOrNull()
                Text("🏆 Winner Takes All: $winner", style = MaterialTheme.typography.bodyLarge)
            }
            "tieredWinnersCircle" -> {
                Text("🥇 Top 3 Winners (1/3 of Pot)", style = MaterialTheme.typography.bodyMedium)
                resultMap.entries.take(3).forEachIndexed { i, entry ->
                    Text("${i + 1}. ${entry.key} – ${(entry.value * 100).toInt()}%")
                }
                Spacer(modifier = Modifier.height(12.dp))
                Text("🎗 Consolation Winners (40% split 2/3)", style = MaterialTheme.typography.bodyMedium)
                resultMap.entries.drop(3).forEach {
                    Text("${it.key} – ${(it.value * 100).toInt()}%")
                }
            }
            "sixtyPercentSplit" -> {
                Text("📊 60% of Entrants Split the Pot", style = MaterialTheme.typography.bodyMedium)
                resultMap.forEach {
                    Text("${it.key} – ${(it.value * 100).toInt()}%")
                }
            }
            "capped", "uncapped" -> {
                val winner = resultMap.keys.firstOrNull()
                Text("🎯 Daily Winner: $winner", style = MaterialTheme.typography.bodyLarge)
            }
            else -> Text("⚠️ Unknown Raffle Type")
        }
    }
}

