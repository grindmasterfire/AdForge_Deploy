import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui.chat

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.CipherBotViewModel

@Composable
fun CipherBotChatScreen(vm: CipherBotViewModel = viewModel()) {
    val messages by vm.botMessages.collectAsState()
    Column(modifier = Modifier.padding(16.dp)) {
        Text("CipherBot Chat", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(messages) { msg ->
                Text(msg, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(vertical = 4.dp))
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        var input by remember { mutableStateOf("") }
        OutlinedTextField(
            value = input,
            onValueChange = { input = it },
            label = { Text("Send a message") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            if (input.isNotBlank()) {
                vm.addBotMessage(input)
                input = ""
            }
        }) {
            Text("Send")
        }
    }
}

