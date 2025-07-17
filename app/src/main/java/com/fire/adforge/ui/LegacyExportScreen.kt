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
import com.fire.adforge.admin.LegacyVaultExporter

@Composable
fun LegacyExportScreen() {
    var result by remember { mutableStateOf<String?>(null) }
    val exporter = remember { LegacyVaultExporter() }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("🗄️ Export Ledger Archive", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(12.dp))

        Button(onClick = {
            exporter.exportAll { success ->
                result = if (success) "✅ Export Complete to /exports" else "❌ Export Failed"
            }
        }) {
            Text("🔐 Export Full Ledger Snapshot")
        }

        Spacer(Modifier.height(10.dp))
        result?.let { Text(it) }
    }
}

