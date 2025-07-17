import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.ChatViewModel

@Composable
fun ChatScreen(viewModel: ChatViewModel = viewModel()) {
    val messages by viewModel.messages.collectAsState()
    var input by remember { mutableStateOf("") }
    val channel = "general"

    LaunchedEffect(Unit) {
        viewModel.listenToChannel(channel)
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("🪐 #General – The Core Forge", style = MaterialTheme.typography.headlineSmall)
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(messages.size) { i ->
                val msg = messages[i]
                Text("\: \")
            }
        }
        OutlinedTextField(value = input, onValueChange = { input = it }, modifier = Modifier.fillMaxWidth())
        Button(onClick = {
            viewModel.sendMessage("CipherBot", input, channel)
            input = ""
        }) {
            Text("Send")
        }
    }
}

