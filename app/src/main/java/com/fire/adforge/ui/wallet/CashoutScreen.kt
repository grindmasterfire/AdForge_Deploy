package com.fire.adforge.ui.wallet

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.CashoutViewModel

@Composable
fun CashoutScreen() {
    val vm: CashoutViewModel = viewModel()
    val selectedMethod by vm.selectedMethod.collectAsState()
    val coinBalance by vm.coinBalance.collectAsState()
    var pin by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Cashout Hub", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(12.dp))
        Text("Available Coins: ")

        Spacer(Modifier.height(16.dp))
        Text("Choose Method:")
        DropdownMenuBox(selectedMethod, vm::onSelectMethod)

        Spacer(Modifier.height(16.dp))
        OutlinedTextField(
            value = pin,
            onValueChange = { pin = it },
            label = { Text("Enter PIN or Security Answer") }
        )

        Spacer(Modifier.height(24.dp))
        Button(
            onClick = { vm.initiateCashout(pin) },
            enabled = coinBalance >= 1000
        ) {
            Text("Request Payout")
        }

        Spacer(Modifier.height(16.dp))
        if (vm.statusMessage.isNotBlank()) {
            Text(vm.statusMessage, color = MaterialTheme.colorScheme.primary)
        }
    }
}

@Composable
fun DropdownMenuBox(selected: String, onSelect: (String) -> Unit) {
    val options = listOf("PayPal", "Venmo", "CashApp", "Google Play Points")
    var expanded by remember { mutableStateOf(false) }

    Box {
        Button(onClick = { expanded = true }) {
            Text(selected)
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEach {
                DropdownMenuItem(text = { Text(it) }, onClick = {
                    onSelect(it)
                    expanded = false
                })
            }
        }
    }
}
