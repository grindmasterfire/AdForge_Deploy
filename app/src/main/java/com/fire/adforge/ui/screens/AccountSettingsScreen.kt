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

@Composable
fun AccountSettingsScreen() {
    var isAdult by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp)) {

        Text("⚙️ Account Settings", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("I am 18 or older", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.width(12.dp))
            Switch(checked = isAdult, onCheckedChange = { isAdult = it })
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            // Placeholder: Sync to Firestore
        }) {
            Text("Save Preferences")
        }
    }
}

