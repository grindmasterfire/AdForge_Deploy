import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.CrewSyncViewModel

@Composable
fun CrewSyncStatusScreen(crewSyncViewModel: CrewSyncViewModel = viewModel()) {
    val sessionTriggers = remember { mutableStateOf(crewSyncViewModel.sessionTriggers) }

    LaunchedEffect(Unit) {
        while (true) {
            sessionTriggers.value = crewSyncViewModel.sessionTriggers
            kotlinx.coroutines.delay(1000)
        }
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(24.dp)
        ) {
            Text("Crew Sync Status", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            Text("Activity Triggers This Session: ", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = { crewSyncViewModel.resetSessionTriggers() }) {
                Text("Reset Session Count")
            }
        }
    }
}

