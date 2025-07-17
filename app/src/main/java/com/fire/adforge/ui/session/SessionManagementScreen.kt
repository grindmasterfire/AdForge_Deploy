import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui.session

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.SessionManagementViewModel

@Composable
fun SessionManagementScreen(vm: SessionManagementViewModel = viewModel()) {
    val isActive by vm.isUserActive.collectAsState()
    Column(modifier = Modifier.padding(16.dp)) {
        Text(\"Session Management\", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Text(\"User Active: \\", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { vm.setUserActive(!isActive) }) {
            Text(if (isActive) \"Set Inactive\" else \"Set Active\")
        }
    }
}

