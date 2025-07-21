package com.fire.adforge.ui.breadloop

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.BreadloopViewModel
import com.fire.adforge.engine.RaffleEntryEngine
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun BreadloopScreen() {
    val vm: BreadloopViewModel = viewModel()
    val showGratitude by vm.showGratitudePopup.collectAsState()
    val showBonus by vm.showBonusTicketPopup.collectAsState()
    val raffleId = vm.raffleId.collectAsState().value
    val userId = "demoUser" //  Replace with actual user ID in production

    Box(modifier = Modifier.fillMaxSize()) {
        AutoplayViewer(
            isPlaying = !showGratitude && !showBonus,
            modifier = Modifier.fillMaxSize()
        )

        if (showGratitude) {
            LivenessGratitudePopup(
                raffleId = raffleId,
                onClaim = {
                    CoroutineScope(Dispatchers.IO).launch {
                        RaffleEntryEngine.recordAmoeEntry(userId, raffleId)
                        vm.onClaimAmoeTicket()
                    }
                }
            )
        }

        if (showBonus) {
            RaffleBonusTicketPopup(
                raffleId = raffleId,
                sessionCoins = vm.sessionCoins.value,
                walletCoins = vm.walletCoins.value,
                onPurchase = { source, count ->
                    CoroutineScope(Dispatchers.IO).launch {
                        val success = RaffleEntryEngine.purchaseBonusTickets(
                            userId,
                            raffleId,
                            count,
                            source,
                            vm.sessionCoins.value,
                            vm.walletCoins.value
                        )
                        if (success) {
                            vm.completeBonusTicketFlow()
                        }
                    }
                },
                onDecline = {
                    vm.completeBonusTicketFlow()
                }
            )
        }
    }
}
