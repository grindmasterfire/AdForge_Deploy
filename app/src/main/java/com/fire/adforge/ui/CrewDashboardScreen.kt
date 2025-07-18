package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CrewDashboardScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Crew Dashboard") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text("View your crew’s earnings, rankings, and bonus multipliers here.")
        }
    }
}
