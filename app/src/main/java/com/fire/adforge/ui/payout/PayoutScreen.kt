import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui.payout

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.PayoutViewModel

@Composable
fun PayoutScreen(vm: PayoutViewModel = viewModel()) {
    val pending by vm.pendingPayouts.collectAsState()
    var payoutAmount by remember { mutableStateOf(\"\") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(\"Payout Requests\", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        Text(\"Pending payouts: \ coins\", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = payoutAmount,
            onValueChange = { payoutAmount = it.filter { ch -> ch.isDigit() } },
            label = { Text(\"Enter payout amount\") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            val amt = payoutAmount.toIntOrNull() ?: 0
            if (amt > 0) {
                vm.requestPayout(amt)
                payoutAmount = \"\"
            }
        }) {
            Text(\"Request Payout\")
        }
    }
}

