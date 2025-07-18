package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InviteWallScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Invite Friends") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text("This is the Invite Wall. You’ll be able to see and share your referral link here.")
        }
    }
}
