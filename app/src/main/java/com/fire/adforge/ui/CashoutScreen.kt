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
import com.fire.adforge.viewmodel.CashoutViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CashoutScreen(vm: CashoutViewModel = viewModel()) {
    val coinBalance by vm.coinBalance.collectAsState()
    val selectedMethod by vm.selectedMethod.collectAsState()
    val ageVerified by vm.ageVerified.collectAsState()

    val allMethods = listOf("PayPal", "Venmo", "CashApp", "Google Play Points")
    val methods = if (ageVerified) allMethods else listOf("Google Play Points")

    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text("💸 Cashout Portal", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(12.dp))

        Text("Available Coins: \", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(24.dp))

        Text("Select Payout Method:", style = MaterialTheme.typography.bodyMedium)
        Box {
            OutlinedButton(onClick = { expanded = true }) {
                Text(selectedMethod)
            }
            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                methods.forEach { method ->
                    DropdownMenuItem(
                        text = { Text(method) },
                        onClick = {
                            vm.selectMethod(method)
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { /* hooked in Kit 103 */ },
            enabled = ageVerified || selectedMethod == "Google Play Points"
        ) {
            Text("Submit Cashout")
        }
    }
}

