import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fire.adforge.model.RaffleRegistry
import com.fire.adforge.model.RaffleTemplate

@Composable
fun RaffleRegistryScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Raffle Registry") },
                actions = {
                    IconButton(onClick = {
                        val newTemplate = RaffleRegistry.createEmptyTemplate()
                        navController.navigate("raffleEditor/")
                    }) {
                        Icon(Icons.Default.Add, contentDescription = "New Raffle")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            items(RaffleRegistry.raffles) { raffle ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .combinedClickable(
                            onClick = {
                                navController.navigate("raffle/")
                            },
                            onLongClick = {
                                navController.navigate("raffleEditor/")
                            }
                        )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(raffle.name, style = MaterialTheme.typography.titleLarge)
                        Text("Entry:  coins")
                        Text("Status: ")
                    }
                }
            }
        }
    }
}

