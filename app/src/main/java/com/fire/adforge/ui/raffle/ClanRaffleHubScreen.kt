package com.fire.adforge.ui.raffle

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fire.adforge.raffles.ClanRaffleType

@Composable
fun ClanRaffleHubScreen(onSelect: (String) -> Unit) {
    val raffleTypes = ClanRaffleType.values()

    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("Clan Raffles", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(16.dp))
        LazyColumn {
            items(raffleTypes.size) { index ->
                val type = raffleTypes[index]
                Button(
                    onClick = { onSelect(type.name) },
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
                ) {
                    Text("Enter  Raffle")
                }
            }
        }
    }
}
