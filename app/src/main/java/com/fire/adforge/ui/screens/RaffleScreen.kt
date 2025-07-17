import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fire.adforge.raffle.RaffleTicket
import com.fire.adforge.raffle.RaffleDrawEngine

@Composable
fun RaffleScreen(userId: String, sessionId: String) {
    var tickets by remember { mutableStateOf(emptyList<RaffleTicket>()) }
    var result by remember { mutableStateOf<RaffleTicket?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("??? Raffle Entry", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = {
            val ticket = RaffleTicket(
                ticketId = "ticket_\",
                ownerId = userId,
                sessionId = sessionId,
                timestamp = System.currentTimeMillis()
            )
            tickets = tickets + ticket
        }) {
            Text("Enter Raffle")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = {
            result = RaffleDrawEngine().drawWinner(tickets)
        }) {
            Text("Draw Winner")
        }

        Spacer(modifier = Modifier.height(24.dp))

        result?.let {
            Text("?? Winner: \", style = MaterialTheme.typography.bodyLarge)
        }
    }
}

