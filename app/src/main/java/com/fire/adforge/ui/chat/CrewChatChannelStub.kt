package com.fire.adforge.ui.chat

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CrewChatChannelStub(channelName: String = "#CoreForge") {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Channel: \", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(12.dp))
        Text("🔒 Chat disabled in stub mode. Live crew chat engine coming soon.", style = MaterialTheme.typography.bodyMedium)
    }
}
