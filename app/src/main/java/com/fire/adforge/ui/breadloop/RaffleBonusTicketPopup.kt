package com.fire.adforge.ui.breadloop

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RaffleBonusTicketPopup(
    raffleId: String,
    sessionCoins: Int,
    walletCoins: Int,
    onPurchase: (source: String, count: Int) -> Unit,
    onDecline: () -> Unit
) {
    var ticketCount by remember { mutableStateOf(1) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xAA000000)),
        contentAlignment = Alignment.Center
    ) {
        Card(modifier = Modifier.padding(20.dp)) {
            Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Buy Bonus Tickets for Raffle #", fontSize = 18.sp)
                Spacer(modifier = Modifier.height(12.dp))

                Text("How many additional tickets would you like to buy? (Max 10)")
                Spacer(modifier = Modifier.height(8.dp))

                Slider(
                    value = ticketCount.toFloat(),
                    onValueChange = { ticketCount = it.toInt().coerceIn(1, 10) },
                    valueRange = 1f..10f,
                    steps = 8
                )

                Text("Selected:  ticket(s)")

                Spacer(modifier = Modifier.height(16.dp))
                Text(" Session Coins: ")
                Text(" Wallet Coins: ")

                Spacer(modifier = Modifier.height(16.dp))
                Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
                    Button(
                        onClick = { onPurchase("session", ticketCount) },
                        enabled = sessionCoins >= ticketCount
                    ) {
                        Text("Use Session Coins")
                    }
                    Button(
                        onClick = { onPurchase("wallet", ticketCount) },
                        enabled = walletCoins >= ticketCount
                    ) {
                        Text("Use Wallet Coins")
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))
                TextButton(onClick = onDecline) {
                    Text("No Thanks")
                }
            }
        }
    }
}
