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
import com.fire.adforge.viewmodel.CrewScoreSyncViewModel

@Composable
fun CrewScoreScreen(vm: CrewScoreSyncViewModel = viewModel()) {
    var result by remember { mutableStateOf<String?>(null) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("🚀 Sync Crew Scores", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(12.dp))

        Button(onClick = {
            vm.syncCrewScores()
            result = "✅ Score Sync Triggered"
        }) {
            Text("Sync Now")
        }

        Spacer(Modifier.height(8.dp))
        result?.let { Text(it) }
    }
}

