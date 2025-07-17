import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

val founders = listOf(
    "FIRE001", "FIRE002", "FIRE003", "FIRE004", "FIRE005",
    "FIRE006", "FIRE007", "FIRE008", "FIRE009", "FIRE010"
)

@Composable
fun FoundersWall() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("🚀 Founders Wall", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(12.dp))
        LazyColumn {
            items(founders) { id ->
                Text("• ", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

