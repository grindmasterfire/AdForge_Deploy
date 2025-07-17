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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.RewardViewModel

@Composable
fun RewardConfirmScreen() {
    val rewardViewModel: RewardViewModel = viewModel()
    val redeemThreshold = 100
    var showSuccess by remember { mutableStateOf(false) }

    Column(Modifier.padding(24.dp)) {
        Text("Redeem Reward", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            showSuccess = rewardViewModel.redeem(redeemThreshold)
        }) {
            Text("Redeem \ Coins")
        }

        if (showSuccess) {
            Spacer(modifier = Modifier.height(12.dp))
            Text("? Reward redeemed!", color = MaterialTheme.colorScheme.primary)
        }
    }
}

