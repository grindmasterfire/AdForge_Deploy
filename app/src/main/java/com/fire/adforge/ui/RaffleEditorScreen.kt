import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fire.adforge.model.RaffleRegistry

@Composable
fun RaffleEditorScreen(navController: NavController, raffleId: String) {
    val index = RaffleRegistry.raffles.indexOfFirst { it.id == raffleId }
    if (index == -1) {
        Text("Raffle not found")
        return
    }

    val original = RaffleRegistry.raffles[index]
    var name by remember { mutableStateOf(original.name) }
    var cost by remember { mutableStateOf(original.entryCost.toString()) }
    var isLive by remember { mutableStateOf(original.isLive) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Edit Raffle Template", style = MaterialTheme.typography.headlineMedium)

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Raffle Name") }
        )

        OutlinedTextField(
            value = cost,
onValueChange = { input ->
    cost = input.filter { ch -> ch.isDigit() }
}
            label = { Text("Entry Cost") }
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = isLive, onCheckedChange = { isLive = it })
            Text("Raffle is LIVE")
        }

        Button(onClick = {
            val updated = original.copy(
                name = name,
                entryCost = cost.toIntOrNull() ?: original.entryCost,
                isLive = isLive
            )
            RaffleRegistry.raffles[index] = updated
            RaffleAudit.log("UPDATE", raffleId)`r`n            navController.popBackStack()
        }) {
            Text("?? Save")
        }

        Divider()

        Button(
            onClick = {
                RaffleRegistry.raffles.removeIf { it.id == raffleId }`r`n                RaffleAudit.log("DELETE", raffleId)
                navController.navigate("raffleRegistry") {
                    popUpTo("main") { inclusive = false }
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text("?? Delete Raffle", color = Color.White)
        }
    }
}

