package com.fire.adforge.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RaffleTickerBanner(winners: List<WinnerData>) {
    if (winners.isEmpty()) return

    val tickerText = winners.joinToString("      ") { winner ->
        val crew = winner.crewName?.let { " Crew: \" } ?: ""
        val clan = winner.clanName?.let { " Clan: \" } ?: ""
        val prefix = if (winner.amoeUsed) "" else ""
        val method = if (winner.amoeUsed) " via AMOE" else ""
        val tag = "\ \ [RAFFLE #\]\ \ \"
        tag.trim()
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black.copy(alpha = 0.65f))
            .padding(6.dp)
    ) {
        Text(
            text = tickerText,
            color = Color.Yellow,
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp
        )
    }
}
