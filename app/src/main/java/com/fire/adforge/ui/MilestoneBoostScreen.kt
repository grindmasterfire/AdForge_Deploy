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
import com.fire.adforge.viewmodel.MilestoneBoostViewModel

@Composable
fun MilestoneBoostScreen(viewModel: MilestoneBoostViewModel, userId: String) {
    var coinsToSpend by remember { mutableStateOf(0) }
    var message by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Spend earned coins to speed up sponsor milestones", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = coinsToSpend.toString(),
            onValueChange = { coinsToSpend = it.toIntOrNull() ?: 0 },
            label = { Text("Coins to Spend (5–10% boost)") },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = {
            if (coinsToSpend > 0) {
                viewModel.spendCoinsForBoost(userId, coinsToSpend) {
                    message = if (it) "Milestone Boost Activated!" else "Boost Failed"
                }
            } else {
                message = "Enter valid coin amount"
            }
        }) {
            Text("Boost Milestone")
        }

        Spacer(modifier = Modifier.height(12.dp))
        Text(message)
    }
}

