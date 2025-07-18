package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class MailItem(val title: String, val body: String)

@Composable
fun MailboxScreen() {
    var messages by remember {
        mutableStateOf(
            listOf(
                MailItem("🔥 Crew Bonus!", "You've received 10 coins from crew activity."),
                MailItem("🎉 Raffle Reminder", "Don't forget to enter the 7-day raffle."),
                MailItem("🛠️ Maintenance Notice", "App updates will deploy tonight.")
            )
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text("📬 Mailbox", style = MaterialTheme.typography.headlineLarge)
        Spacer(Modifier.height(16.dp))
        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(messages) { msg ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(msg.title, style = MaterialTheme.typography.titleMedium)
                        Spacer(Modifier.height(8.dp))
                        Text(msg.body, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}
