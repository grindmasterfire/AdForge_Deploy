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
fun LegalScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp)) {

        Text("📜 Legal & Compliance", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        Text("1. Terms of Service", style = MaterialTheme.typography.titleMedium)
        Text("View: terms_of_service.txt")

        Spacer(modifier = Modifier.height(12.dp))
        Text("2. Privacy Policy", style = MaterialTheme.typography.titleMedium)
        Text("View: privacy_policy.txt")

        Spacer(modifier = Modifier.height(12.dp))
        Text("3. Raffle Rules", style = MaterialTheme.typography.titleMedium)
        Text("View: raffle_rules.txt")

        Spacer(modifier = Modifier.height(12.dp))
        Text("4. AMOE (No Purchase Necessary)", style = MaterialTheme.typography.titleMedium)
        Text("View: amoe_notice.txt")

        Spacer(modifier = Modifier.height(20.dp))
        Text("All documents are available in the app/assets folder or at adforge.app/legal", style = MaterialTheme.typography.bodyMedium)
    }
}

