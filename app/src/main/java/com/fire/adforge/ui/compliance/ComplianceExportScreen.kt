package com.fire.adforge.ui.compliance

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.AmoeExportViewModel

@Composable
fun ComplianceExportScreen() {
    val context: Context = LocalContext.current
    val vm: AmoeExportViewModel = viewModel()
    var resultMessage by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(" AMOE Compliance Export", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(16.dp))

        Button(onClick = {
            vm.exportAmoeCSV(context) { success, msg ->
                resultMessage = msg
            }
        }) {
            Text("Export AMOE Log to CSV")
        }

        Spacer(Modifier.height(16.dp))
        if (resultMessage.isNotBlank()) {
            Text(resultMessage)
        }
    }
}
