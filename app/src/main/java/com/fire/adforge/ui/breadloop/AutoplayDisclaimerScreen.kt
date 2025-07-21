package com.fire.adforge.ui.breadloop

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AutoplayDisclaimerScreen(onAccept: () -> Unit, onExit: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Autoplay Disclaimer",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(18.dp))

        Text(
            text = """
 This feature may activate your devices camera to confirm a real person is watching (liveness check). No photos or videos are stored.
 Headphones or active volume are recommended to ensure engagement is detected.
 You must remain present for the full duration of the ad to earn rewards and raffle entries.
 Using bots, emulators, screen spoofing, or any attempt to fake activity will result in disqualification.
 No purchase is necessary to enter raffles. Users may qualify through time, attention, or alternative free methods (AMOE).

By tapping "I Agree", you confirm you understand and accept these terms. Your participation may be monitored to ensure fair play and compliance with our Terms of Service and Privacy Policy.
""".trimIndent(),
            color = Color.LightGray,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = onExit, colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)) {
                Text("Exit")
            }
            Button(onClick = onAccept) {
                Text("I Agree")
            }
        }
    }
}
