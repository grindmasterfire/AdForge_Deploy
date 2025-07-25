package com.fire.adforge.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun SponsorMenuScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize().padding(32.dp)) {
        Text("Sponsor Menu", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { navController.navigate("sponsors/board") }, modifier = Modifier.fillMaxWidth()) {
            Text("View Sponsor Directory")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("sponsors/banners") }, modifier = Modifier.fillMaxWidth()) {
            Text("Top Sponsor Banners")
        }
    }
}
