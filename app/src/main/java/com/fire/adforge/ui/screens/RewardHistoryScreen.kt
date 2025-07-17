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
import com.fire.adforge.utils.LedgerEntry

@Composable
fun RewardHistoryScreen(entries: List<LedgerEntry>) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp)) {

        Text("📊 Reward History", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(12.dp))

        entries.sortedByDescending { it.timestamp }.forEach { entry ->
            Column(modifier = Modifier.padding(vertical = 4.dp)) {
                Text("🪙  coins", style = MaterialTheme.typography.bodyMedium)
                Text("Reason: ", style = MaterialTheme.typography.bodyMedium)
                Text("Time: ", style = MaterialTheme.typography.labelSmall)
                Divider(modifier = Modifier.padding(vertical = 6.dp))
            }
        }
    }
}

