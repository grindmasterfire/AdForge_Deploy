import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fire.adforge.engine.MilestoneSpendEngine

@Composable
fun BoosterShopScreen(userCoins: Long) {
    val originalCost = 5000L
    val discountPercent = 10
    val finalCost = MilestoneSpendEngine.calculateDiscountedCost(originalCost, discountPercent)

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp)) {

        Text("⚡ Milestone Boosters", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        Text("Speed up your offer progress with milestone boosters.")
        Text("Original Cost:  coins")
        Text("Discount: %")
        Text("Final Cost:  coins")

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Placeholder: trigger Firebase or UI update
            },
            enabled = userCoins >= finalCost
        ) {
            Text("Activate Booster")
        }

        if (userCoins < finalCost) {
            Text("❌ Not enough coins", style = MaterialTheme.typography.labelSmall)
        }
    }
}

