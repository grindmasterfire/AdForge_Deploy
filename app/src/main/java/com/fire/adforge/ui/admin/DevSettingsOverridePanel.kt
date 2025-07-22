package com.fire.adforge.ui.admin

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DevSettingsOverridePanel() {
    var debugCoins by remember { mutableStateOf(0) }
    var timeWarpEnabled by remember { mutableStateOf(false) }
    var skipAMOE by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
        Text("Dev Override Panel", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = debugCoins.toString(),
            onValueChange = { debugCoins = it.toIntOrNull() ?: 0 },
            label = { Text("Inject Coins") }
        )
        Spacer(modifier = Modifier.height(12.dp))

        Row {
            Checkbox(checked = timeWarpEnabled, onCheckedChange = { timeWarpEnabled = it })
            Text("Enable Time Warp Mode", modifier = Modifier.padding(start = 8.dp))
        }

        Row {
            Checkbox(checked = skipAMOE, onCheckedChange = { skipAMOE = it })
            Text("Skip AMOE Prompt", modifier = Modifier.padding(start = 8.dp))
        }

        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {
            // Placeholder: Apply debug overrides
        }) {
            Text("Apply Overrides")
        }
    }
}
