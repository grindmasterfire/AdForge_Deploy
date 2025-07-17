import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fire.adforge.ALPHA_VERSION
import com.fire.adforge.BUILD_TIMESTAMP
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.BuildMetaViewModel

@Composable
fun AdminFirestampScreen() {
    viewModel<BuildMetaViewModel>() // Triggers Firebase write
    Column(modifier = Modifier.padding(16.dp)) {
        Text("🔥 AdForge Alpha Mark", style = MaterialTheme.typography.headlineLarge)
        Spacer(Modifier.height(16.dp))
        Text("Version: \")
        Text("Timestamp: \")
        Text("Owner: Fire")
    }
}

