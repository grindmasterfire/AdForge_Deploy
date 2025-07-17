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
import com.fire.adforge.viewmodel.CoinLedgerViewModel

@Composable
fun LedgerDebugScreen(userId: String = "debugUser") {
    val vm = viewModel<CoinLedgerViewModel>()
    var input by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("💰 Ledger Debug", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))
        OutlinedTextField(value = input, onValueChange = { input = it }, label = { Text("Coin Delta") })
        Button(onClick = {
            val delta = input.toLongOrNull() ?: 0L
            vm.updateCoinBalance(userId, delta, "Manual Debug Entry")
            input = ""
        }) {
            Text("Submit Delta")
        }
    }
}

