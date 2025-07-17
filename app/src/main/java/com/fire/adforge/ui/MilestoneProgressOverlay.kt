import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.fire.adforge.viewmodel.MilestonePoolViewModel

@Composable
fun MilestoneProgressOverlay(vm: MilestonePoolViewModel, goal: Int) {
    val current by vm.pool.collectAsState()

    val percent = (current.toFloat() / goal).coerceIn(0f, 1f)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0x11000000))
            .padding(8.dp)
    ) {
        Text("Milestone Progress: $current / $goal coins")
        LinearProgressIndicator(progress = percent)
    }
}

