package com.fire.adforge

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MainScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize().padding(32.dp)) {
        Text("AdForge Main", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { navController.navigate("sponsors/menu") }, modifier = Modifier.fillMaxWidth()) {
            Text("Explore Sponsors")
        }

        // Add more main screen buttons here as needed
    }
}
