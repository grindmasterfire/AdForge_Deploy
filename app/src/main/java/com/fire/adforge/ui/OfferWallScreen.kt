import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.MilestoneLogViewModel
import com.fire.adforge.viewmodel.MilestonePoolViewModel

@Composable
fun OfferWallScreen() {
    val logVM: MilestoneLogViewModel = viewModel()
    val poolVM: MilestonePoolViewModel = viewModel()

    val offerId = "sampleOffer123"
    val goal = 10000

    logVM.fetchLog(offerId)
    poolVM.observePool(offerId)

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        MilestoneProgressOverlay(vm = poolVM, goal = goal)
        Spacer(modifier = Modifier.height(12.dp))
        BoostHistoryCard(vm = logVM)

        Spacer(modifier = Modifier.height(24.dp))
        LazyColumn {
            items(1) {
                OfferWallItem(
                    offer = Offer(
                        id = offerId,
                        title = "Example Game Offer",
                        reward = 300,
                        boostCost = 500
                    )
                )
            }
        }
    }
}

