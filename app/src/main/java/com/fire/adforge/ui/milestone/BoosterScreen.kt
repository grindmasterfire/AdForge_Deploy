package com.fire.adforge.ui.milestone

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.BoosterViewModel

@Composable
fun BoosterScreen(boosterViewModel: BoosterViewModel = viewModel()) {
    val context = LocalContext.current
    val earnedCoins by boosterViewModel.earnedCoins.collectAsState()
    val discountPercent by boosterViewModel.selectedDiscount.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Milestone Booster", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        Text("Your Earned Coins: ", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(16.dp))

        Text("Select Booster Discount", style = MaterialTheme.typography.titleMedium)
        Slider(
            value = discountPercent.toFloat(),
            onValueChange = { boosterViewModel.updateDiscount(it.toInt()) },
            valueRange = 5f..10f,
            steps = 4
        )
        Text("Selected Discount: %", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            val success = boosterViewModel.applyBooster()
            val msg = if (success) "Booster applied!" else "Not enough earned coins!"
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }) {
            Text("Activate Booster")
        }
    }
}
