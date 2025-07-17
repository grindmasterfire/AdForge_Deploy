package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fire.adforge.model.RaffleAudit
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun AuditTrailScreen() {
    val logs = remember { RaffleAudit.logs.toList().reversed() }
    val dateFormat = remember { SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("🕵️ Audit Trail") })
        }
    ) { padding ->
        LazyColumn(modifier = Modifier
            .padding(padding)
            .padding(16.dp)) {
            items(logs) { entry ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Action: ")
                        Text("Raffle ID: ")
                        Text("Time: ")
                    }
                }
            }
        }
    }
}
