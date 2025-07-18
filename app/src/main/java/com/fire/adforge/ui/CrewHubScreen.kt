package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CrewHubScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Crew Hub") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text("Welcome to the Crew Hub. Crew management and boosts will appear here.")
        }
    }
}
