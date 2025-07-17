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

@Composable
fun PayoutScreen() {
    var selectedMethod by remember { mutableStateOf("PayPal") }
    val payoutMethods = listOf("PayPal", "Venmo", "CashApp")

    Column(modifier = Modifier.padding(16.dp)) {
        Text("💸 Request Payout", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        payoutMethods.forEach { method ->
            Row(modifier = Modifier.fillMaxWidth()) {
                RadioButton(
                    selected = (method == selectedMethod),
                    onClick = { selectedMethod = method }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(method)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /* TODO: Handle payout request */ }) {
            Text("Submit Payout")
        }
    }
}

