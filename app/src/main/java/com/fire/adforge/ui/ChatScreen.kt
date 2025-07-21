import java.text.SimpleDateFormat
import com.fire.adforge.ui.components.RaffleTickerBanner
import com.fire.adforge.viewmodel.RaffleTickerViewModel
import java.util.Locale
import com.fire.adforge.ui.components.RaffleTickerBanner
import com.fire.adforge.viewmodel.RaffleTickerViewModel
import android.util.Log
import com.fire.adforge.ui.components.RaffleTickerBanner
import com.fire.adforge.viewmodel.RaffleTickerViewModel
import androidx.compose.material3.MaterialTheme
import com.fire.adforge.ui.components.RaffleTickerBanner
import com.fire.adforge.viewmodel.RaffleTickerViewModel
import androidx.compose.material3.Text
import com.fire.adforge.ui.components.RaffleTickerBanner
import com.fire.adforge.viewmodel.RaffleTickerViewModel
package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import com.fire.adforge.ui.components.RaffleTickerBanner
import com.fire.adforge.viewmodel.RaffleTickerViewModel
import androidx.compose.foundation.lazy.LazyColumn
import com.fire.adforge.ui.components.RaffleTickerBanner
import com.fire.adforge.viewmodel.RaffleTickerViewModel
import androidx.compose.material3.*
import com.fire.adforge.ui.components.RaffleTickerBanner
import com.fire.adforge.viewmodel.RaffleTickerViewModel
import androidx.compose.runtime.*
import com.fire.adforge.ui.components.RaffleTickerBanner
import com.fire.adforge.viewmodel.RaffleTickerViewModel
import androidx.compose.ui.Modifier
import com.fire.adforge.ui.components.RaffleTickerBanner
import com.fire.adforge.viewmodel.RaffleTickerViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.ui.components.RaffleTickerBanner
import com.fire.adforge.viewmodel.RaffleTickerViewModel
import com.fire.adforge.viewmodel.ChatViewModel
import com.fire.adforge.ui.components.RaffleTickerBanner
import com.fire.adforge.viewmodel.RaffleTickerViewModel

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

