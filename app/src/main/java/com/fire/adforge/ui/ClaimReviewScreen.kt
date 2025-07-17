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
import com.fire.adforge.viewmodel.ClaimReviewViewModel

@Composable
fun ClaimReviewScreen(vm: ClaimReviewViewModel = viewModel()) {
    val claims = vm.claims.collectAsState()
    val raffleId = "default"

    Column(modifier = Modifier.padding(16.dp)) {
        Text("📜 Submitted Claims", style = MaterialTheme.typography.headlineMedium)

        claims.value.forEach { userId ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("👤 ")
                Button(onClick = { vm.verifyClaim(raffleId, userId) }) {
                    Text("✅ Verify")
                }
            }
        }
    }
}

