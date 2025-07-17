import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fire.adforge.viewmodel.ClanViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ClanJoinScreen(vm: ClanViewModel = viewModel()) {
    var clanId by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text("Join a Clan", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = clanId,
            onValueChange = { clanId = it },
            label = { Text("Clan ID") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            vm.joinClan("testUser", clanId) {
                message = if (it) "Joined !" else "Failed to join."
            }
        }) {
            Text("Join Clan")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(message)
    }
}

