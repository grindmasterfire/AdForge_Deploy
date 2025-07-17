import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui.raffle

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DailyRaffleResultScreen(winnerName: String?, prizeAmount: Int?) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Daily Raffle Result", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        if (winnerName != null && prizeAmount != null) {
            Text("Winner: winnerName", style = MaterialTheme.typography.bodyLarge)
            Text("Prize: prizeAmount coins", style = MaterialTheme.typography.bodyLarge)
        } else {
            Text("No results available yet.", style = MaterialTheme.typography.bodyLarge)
        }
    }
}

