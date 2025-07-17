import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fire.adforge.util.ClanRaffleManager

@Composable
fun ClanRaffleStatusScreen(userId: String) {
    val entries by ClanRaffleManager.entryLog.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text("Clan Raffle Status", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Total Entries: ", style = MaterialTheme.typography.bodyMedium)

        val myTickets = ClanRaffleManager.getUserTickets(userId)
        Spacer(modifier = Modifier.height(8.dp))
        Text("You have  ticket(s)", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(24.dp))
        Text("All Entries", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(entries.entries.toList()) { (id, count) ->
                Text("• :  ticket(s)", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

