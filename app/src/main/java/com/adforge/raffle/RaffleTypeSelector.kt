package com.adforge.raffle

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*

@Composable
fun RaffleTypeSelector(onTypeSelected: (RaffleType) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    var selected by remember { mutableStateOf(RaffleType.WINNER_TAKES_ALL) }

    Column {
        Text("Raffle Mode: " + selected.name)
        Button(onClick = { expanded = true }) {
            Text("Change Raffle Type")
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            RaffleType.values().forEach { type ->
                DropdownMenuItem(onClick = {
                    selected = type
                    onTypeSelected(type)
                    expanded = false
                }) {
                    Text(type.name)
                }
            }
        }
    }
}
