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
import com.fire.adforge.viewmodel.MilestoneViewModel

data class Offer(
    val id: String,
    val title: String,
    val reward: Int,
    val boostCost: Int
)

@Composable
fun OfferWallItem(offer: Offer) {
    val vm: MilestoneViewModel = viewModel()

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(12.dp)) {

        Text(text = offer.title, style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(4.dp))
        Text("Reward: ${offer.reward} coins", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { vm.launchSpend(offer.id, offer.boostCost) }) {
            Text("Boost Progress")
        }
    }
}

