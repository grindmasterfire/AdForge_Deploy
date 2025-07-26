import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui.milestone

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.MilestoneViewModel

@Composable
fun MilestoneScreen(vm: MilestoneViewModel = viewModel()) {
    val spent by vm.spentCoins.collectAsState()
    val discount = vm.getDiscount()
    var spendAmount by remember { mutableStateOf(\"\") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(\"Milestone Spend Incentive\", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        Text(\"Coins spent: \\", style = MaterialTheme.typography.bodyLarge)
        Text(String.format(\"Current discount: %.0f%%\", discount * 100), style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = spendAmount,
onValueChange = { input ->
    spendAmount = input.filter { ch -> ch.isDigit() }
}
            label = { Text(\"Enter coins to spend\") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            val amt = spendAmount.toIntOrNull() ?: 0
            if (amt > 0) {
                vm.spendCoins(amt)
                spendAmount = \"\"
            }
        }) {
            Text(\"Spend Coins\")
        }
    }
}

