import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fire.adforge.security.ForgeLockManager

@Composable
fun ForgeLockScreen() {
    val manager = remember { ForgeLockManager() }
    var raffleId by remember { mutableStateOf("") }
    var result by remember { mutableStateOf<String?>(null) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("🔒 Vault Lock Protocol", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(12.dp))

        OutlinedTextField(
            value = raffleId,
            onValueChange = { raffleId = it },
            label = { Text("Raffle ID") }
        )

        Spacer(Modifier.height(12.dp))

        Button(onClick = {
            manager.lockRaffle(raffleId) {
                result = if (it) "✅ Raffle  sealed." else "❌ Lock failed."
            }
        }) {
            Text("Seal Raffle")
        }

        Spacer(Modifier.height(8.dp))
        result?.let { Text(it) }
    }
}

