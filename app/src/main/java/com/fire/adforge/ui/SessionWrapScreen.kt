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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.SessionWrapViewModel

@Composable
fun SessionWrapScreen(vm: SessionWrapViewModel = viewModel()) {
    var raffleId by remember { mutableStateOf("RAFFLE123") }
    var result by remember { mutableStateOf<String?>(null) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("🔒 Finalize Raffle Session", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = raffleId,
            onValueChange = { raffleId = it },
            label = { Text("Raffle ID") }
        )

        Spacer(Modifier.height(12.dp))
        Button(onClick = {
            vm.finalizeRaffle(raffleId) {
                result = if (it) "✅ Finalized & Payouts Queued" else "❌ Finalization Failed"
            }
        }) {
            Text("Finalize & Queue Payouts")
        }

        Spacer(Modifier.height(10.dp))
        result?.let { Text(it) }
    }
}

