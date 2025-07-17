import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui.clan
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.ClanRaffleViewModel

@Composable
fun ClanRaffleStatusScreen(vm: ClanRaffleViewModel = viewModel()) {
    val ticketMap by vm.clanTicketMap.collectAsState()
    val coinMap by vm.coinWeightMap.collectAsState()
    val coinMap by vm.coinWeightMap.collectAsState()
    Column(Modifier.padding(16.dp)) {
        Text("Clan Raffle Status", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(16.dp))
        ticketMap.forEach { (id, count) ->
            Text("• id: count ticket(s)", style = MaterialTheme.typography.bodyLarge)
        }
        Spacer(Modifier.height(24.dp))
        Button(onClick = { vm.syncClanStatus() }) {
            Text(if (showDebug) "Hide Debug Info" else "Show Debug Info", style = MaterialTheme.typography.labelLarge)
        }
    }
}

