package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StatsAndActivityScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Stats & Activity") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text("Here you'll view your coin earnings, ad history, offer completions, and crew activity.")
        }
    }
}
