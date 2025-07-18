package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AdForgeStoreScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("AdForge Store") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text("Spend coins, claim milestone perks, and purchase boosters here.")
        }
    }
}
