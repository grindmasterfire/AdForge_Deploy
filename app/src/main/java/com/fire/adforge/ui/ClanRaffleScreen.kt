package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ClanRaffleScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Clan Raffle") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text("Clan Raffle entries, standings, and countdown will be displayed here.")
        }
    }
}
