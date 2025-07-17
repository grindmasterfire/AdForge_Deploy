import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.ChatViewModel

@Composable
fun ForgeChatScreen(channel: String = "general", userId: String, vm: ChatViewModel = viewModel()) {
    var message by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("#\", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(16.dp))

        // Message input
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            BasicTextField(
                value = message,
                onValueChange = { message = it },
                modifier = Modifier.weight(1f).padding(end = 8.dp)
            )
            Button(onClick = {
                if (message.isNotBlank()) {
                    vm.sendMessage(channel, userId, message)
                    message = ""
                }
            }) {
                Text("Send")
            }
        }

        Spacer(Modifier.height(32.dp))
        Text("⚠️ Message feed placeholder. Add listener later.")
    }
}

