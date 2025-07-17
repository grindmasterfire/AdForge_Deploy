package com.fire.adforge.ui.mail

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.MailViewModel

@Composable
fun MailCenterScreen() {
    val vm = viewModel<MailViewModel>()
    val messages = vm.messages.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("📬 Inbox", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(12.dp))
        if (messages.isEmpty()) {\n            Text("📭 No messages yet. Stay tuned!")\n        } else messages.forEach {
            Text("✉️ " + it, style = MaterialTheme.typography.bodySmall)
        }
    }
}
