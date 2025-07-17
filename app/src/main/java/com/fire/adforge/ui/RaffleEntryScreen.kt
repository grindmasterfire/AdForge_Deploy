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

@Composable
fun RaffleEntryScreen(ageVerified: Boolean) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text("🎟️ Raffle Entry", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        if (!ageVerified) {
            Text("Access Denied", style = MaterialTheme.typography.titleMedium)
            Text("Raffles are not available to underage users.")
            return
        }

        // Raffle UI if verified
        Text("You're eligible to enter the raffle!", style = MaterialTheme.typography.bodyLarge)
        Button(onClick = { /* enter raffle */ }) {
            Text("Enter Now")
        }
    }
}

