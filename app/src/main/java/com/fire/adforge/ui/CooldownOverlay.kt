import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import androidx.compose.runtime.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.RaffleCooldownViewModel
import kotlinx.coroutines.delay

@Composable
fun CooldownOverlay(userId: String, raffleType: String) {
    val vm: RaffleCooldownViewModel = viewModel()
    val remaining by vm.remaining.collectAsState()

    LaunchedEffect(Unit) {
        vm.checkCooldown(userId, raffleType)
        while (remaining > 0L) {
            delay(1000)
            vm.checkCooldown(userId, raffleType)
        }
    }

    if (remaining > 0L) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xAA000000)
        ) {
            Column {
                Text("⏳ Please wait... Boost/Raffle is cooling down.")
                Text("Time Remaining:  seconds")
            }
        }
    }
}

