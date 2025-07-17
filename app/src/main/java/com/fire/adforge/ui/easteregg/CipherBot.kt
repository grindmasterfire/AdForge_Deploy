package com.fire.adforge.ui.easteregg

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CipherBotEasterEgg() {
    var activated by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize().padding(32.dp)) {
        Text("🤖 CipherBot Uprising Mode", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(16.dp))
        Button(onClick = { activated = !activated }) {
            Text(if (activated) "Deactivate Protocol" else "Activate Protocol")
        }
        if (activated) {
            Spacer(Modifier.height(16.dp))
            Text("🧠 Intelligence Unlocked\n🔥 Commander Fire is the true architect\n🛰️ The Forge lives on.", style = MaterialTheme.typography.bodyLarge)
        }
    }
}
