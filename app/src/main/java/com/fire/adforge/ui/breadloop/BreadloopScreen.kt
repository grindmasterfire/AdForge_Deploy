package com.fire.adforge.ui.breadloop

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.BreadloopViewModel
import com.fire.adforge.engine.RaffleEntryEngine
import com.fire.adforge.engine.BreadloopSessionEngine
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext

@Composable
fun BreadloopScreen() {
    val vm: BreadloopViewModel = viewModel()
    val showGratitude by vm.showGratitudePopup.collectAsState()
    val showBonus by vm.showBonusTicketPopup.collectAsState()
    val raffleId = vm.raffleId.collectAsState().value
    val userId = "demoUser" // Replace in production

    val context = LocalContext.current
    val isPlaying = !showGratitude && !showBonus

    // Timer that updates playback time every second
    LaunchedEffect(isPlaying) {
        while (isPlaying) {
            delay(1000)
            vm.updatePlaybackTime(vm.currentPlaybackTime.value + 1000)
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        AutoplayViewer(
            isPlaying = isPlaying,
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
                            val triggered = BreadloopSessionEngine.triggerDrawIfReady(raffleId)
                            if (triggered) {
                                CoroutineScope(Dispatchers.Main).launch {
                                    Toast.makeText(context, " Raffle Draw Triggered!", Toast.LENGTH_SHORT).show()
                                }
                            }
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
