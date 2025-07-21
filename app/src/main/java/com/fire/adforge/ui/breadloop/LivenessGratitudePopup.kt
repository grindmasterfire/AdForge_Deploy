package com.fire.adforge.ui.breadloop

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LivenessGratitudePopup(
    raffleId: String,
    onClaim: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xDD000000)),
        contentAlignment = Alignment.Center
    ) {
        Card(modifier = Modifier.padding(20.dp)) {
            Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(" Thank you for your engagement!", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(12.dp))
                Text("Our sponsors appreciate your time and hope youve enjoyed the content so far.")
                Spacer(modifier = Modifier.height(8.dp))
                Text("As a thank you, you've been awarded a FREE raffle ticket for:")
                Spacer(modifier = Modifier.height(8.dp))
                Text(" Raffle #", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(18.dp))
                Button(onClick = onClaim) {
                    Text("Claim My Free Ticket")
                }
            }
        }
    }
}
