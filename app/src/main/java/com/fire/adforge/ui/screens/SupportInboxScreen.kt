import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class SupportMessage(
    val title: String,
    val body: String,
    val timestamp: Long
)

@Composable
fun SupportInboxScreen(messages: List<SupportMessage>) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp)) {

        Text("📥 Support Inbox", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        if (messages.isEmpty()) {
            Text("No messages at this time.", style = MaterialTheme.typography.bodyMedium)
        } else {
            messages.sortedByDescending { it.timestamp }.forEach { msg ->
                Column(modifier = Modifier.padding(bottom = 16.dp)) {
                    Text(msg.title, style = MaterialTheme.typography.titleMedium)
                    Text(msg.body, style = MaterialTheme.typography.bodyMedium)
                    Text("⏱️ ", style = MaterialTheme.typography.labelSmall)
                    Divider(modifier = Modifier.padding(vertical = 8.dp))
                }
            }
        }
    }
}

