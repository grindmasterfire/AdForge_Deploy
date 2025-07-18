package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ClanHubScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Clan Hub") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text("Welcome to the Clan Hub. Clan stats and management will be shown here.")
        }
    }
}
