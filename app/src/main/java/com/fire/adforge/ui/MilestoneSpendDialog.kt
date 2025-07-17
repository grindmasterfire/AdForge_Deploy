import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.window.Dialog
import com.fire.adforge.engine.MilestoneEngine

@Composable
fun MilestoneSpendDialog(
    offerId: String,
    baseCost: Int,
    onConfirm: (Int) -> Unit,
    onDismiss: () -> Unit
) {
    val finalCost = MilestoneEngine.calculateDiscountedCost(baseCost, true)

    Dialog(onDismissRequest = onDismiss) {
        Surface(shape = MaterialTheme.shapes.medium) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text("Boost Milestone", style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.height(12.dp))
                Text("Base Cost: $baseCost coins")
                Text("Discounted: $finalCost coins (earned only)")
                Spacer(modifier = Modifier.height(12.dp))
                Row {
                    Button(onClick = { onConfirm(finalCost) }) {
                        Text("Boost")
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    OutlinedButton(onClick = onDismiss) {
                        Text("Cancel")
                    }
                }
            }
        }
    }
}

