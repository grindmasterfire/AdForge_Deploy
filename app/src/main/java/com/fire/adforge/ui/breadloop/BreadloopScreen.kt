package com.fire.adforge.ui.breadloop

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.BreadloopViewModel

@Composable
fun BreadloopScreen() {
    val vm: BreadloopViewModel = viewModel()
    val showGratitude by vm.showGratitudePopup.collectAsState()
    val showBonus by vm.showBonusTicketPopup.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        // Main Breadloop autoplay viewer
        AutoplayViewer(
            isPlaying = !showGratitude && !showBonus,
            modifier = Modifier.fillMaxSize()
        )

        // Phase 1: Gratitude Popup
        if (showGratitude) {
            LivenessGratitudePopup(
                raffleId = vm.raffleId.value,
                onClaim = { vm.onClaimAmoeTicket() }
            )
        }

        // Phase 2: Bonus Ticket Popup
        if (showBonus) {
            RaffleBonusTicketPopup(
                raffleId = vm.raffleId.value,
                sessionCoins = vm.sessionCoins.value,
                walletCoins = vm.walletCoins.value,
                onPurchase = { source, count ->
                    // TODO: Deduct coins and register entries
                    vm.completeBonusTicketFlow()
                },
                onDecline = {
                    vm.completeBonusTicketFlow()
                }
            )
        }
    }
}
