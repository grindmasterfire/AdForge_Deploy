import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui`nimport com.fire.adforge.util.isAdmin`nimport com.fire.adforge.util.pickClanRaffleWinner

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ClanRaffleScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text("Clan Raffles", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text("View active clan raffles, enter now, or see winners.", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = { /* TODO: Entry logic */ }) {
            validateClanMembership("CURRENT_USER_ID", "CLAN_ID") { valid ->
    if (valid) submitClanRaffleEntry("CURRENT_USER_ID", "CLAN_ID") { success -> println("Entry status: \$success") }
Text("Enter Current Clan Raffle")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /* TODO: Navigate to history */ }) {
            Text("View Past Winners")
        }
    }
}



