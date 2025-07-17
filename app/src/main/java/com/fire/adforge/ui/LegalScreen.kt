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
import com.fire.adforge.viewmodel.LegalViewModel

@Composable
fun LegalScreen(userId: String, vm: LegalViewModel = viewModel()) {
    var accepted by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("📜 Terms of Service", style = MaterialTheme.typography.headlineSmall)
        Text("By using AdForge, you agree to the following terms...") // (Insert ToS text here)

        Spacer(modifier = Modifier.height(16.dp))

        Text("🔒 Privacy Policy", style = MaterialTheme.typography.headlineSmall)
        Text("We do not collect PII. You remain anonymous...") // (Insert privacy policy)

        Spacer(modifier = Modifier.height(24.dp))

        if (!accepted) {
            Button(onClick = {
                vm.acceptLegal(userId)
                accepted = true
            }) {
                Text("✅ Accept & Continue")
            }
        } else {
            Text("✅ Terms accepted.")
        }
    }
}

