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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.AMOEViewModel

@Composable
fun AMOEScreen(raffleId: String, userId: String, vm: AMOEViewModel = viewModel()) {
    var submitted by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("📝 Alternate Means of Entry", style = MaterialTheme.typography.headlineMedium)

        if (submitted) {
            Text("✅ You’ve been entered into the raffle via AMOE.")
        } else {
            Text("No purchase or coins necessary. Enter by pressing below.")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                vm.submitAMOE(raffleId, userId)
                submitted = true
            }) {
                Text("Enter via AMOE")
            }
        }
    }
}

