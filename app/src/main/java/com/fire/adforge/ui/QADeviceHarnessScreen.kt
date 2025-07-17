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
import com.fire.adforge.viewmodel.QADeviceViewModel

@Composable
fun QADeviceHarnessScreen(vm: QADeviceViewModel = viewModel()) {
    val deviceStatus by vm.deviceStatus.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("QA Console", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Status: $deviceStatus")
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { vm.runDiagnostics() }) {
            Text("Run Diagnostics")
        }
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = { vm.reset() }) {
            Text("Reset")
        }
    }
}

