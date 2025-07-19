package com.fire.adforge.ui.claims

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.PayoutQueueViewModel

@Composable
fun PayoutRequestScreen(currentUserId: String) {
    val viewModel: PayoutQueueViewModel = viewModel()
    var amount by remember { mutableStateOf("") }
    var method by remember { mutableStateOf("PayPal") }
    var status by remember { mutableStateOf<String?>(null) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Request a Payout", style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = amount,
            onValueChange = { amount = it },
            label = { Text("Amount (coins)") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        DropdownMenu(
            expanded = false,
            onDismissRequest = {},
        ) {
            // For future use if you want dropdown
        }

        Row {
            Text("Method:")
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { method = "PayPal" }) { Text("PayPal") }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { method = "CashApp" }) { Text("CashApp") }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val amt = amount.toIntOrNull()
            if (amt != null && amt > 0) {
                viewModel.submitRequest(currentUserId, method, amt)
                status = "Submitted"
            } else {
                status = "Enter a valid amount"
            }
        }) {
            Text("Submit Request")
        }

        status?.let {
            Spacer(modifier = Modifier.height(8.dp))
            Text(it)
        }
    }
}
