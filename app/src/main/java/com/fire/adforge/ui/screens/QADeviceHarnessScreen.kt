import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodels.QADeviceViewModel

@Composable
fun QADeviceHarnessScreen(viewModel: QADeviceViewModel = viewModel()) {
    val status = viewModel.deviceStatus.value

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Device Diagnostics") }
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Status: $status", style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(24.dp))
                Row {
                    Button(onClick = { viewModel.runDiagnostics() }) {
                        Text("Run")
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Button(onClick = { viewModel.reset() }) {
                        Text("Reset")
                    }
                }
            }
        }
    )
}

