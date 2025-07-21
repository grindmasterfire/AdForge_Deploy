package com.fire.adforge.ui.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SettingsScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Settings", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { navController.navigate("personal_wall") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
        ) { Text(" View My Wall") }

        Button(
            onClick = { navController.navigate("crew_wall") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
        ) { Text(" View Crew Wall") }

        Button(
            onClick = { navController.navigate("clan_wall") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
        ) { Text(" View Clan Wall") }

        Button(
            onClick = { navController.navigate("cipherbot_wall") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
        ) { Text(" Visit CipherBot") }
    }
}
