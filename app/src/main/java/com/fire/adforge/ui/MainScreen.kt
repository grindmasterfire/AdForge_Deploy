package com.fire.adforge.ui

import androidx.compose.foundation.layout.*`nimport com.fire.adforge.ui.CountdownBanner`nimport com.fire.adforge.backend.CrewBadgeBinder`nimport androidx.compose.material.icons.filled.List
import androidx.compose.material3.*`nimport com.fire.adforge.ui.CountdownBanner`nimport com.fire.adforge.backend.CrewBadgeBinder`nimport androidx.compose.material.icons.filled.List
import androidx.compose.runtime.*`nimport com.fire.adforge.ui.CountdownBanner`nimport com.fire.adforge.backend.CrewBadgeBinder`nimport androidx.compose.material.icons.filled.List
import androidx.compose.ui.Alignment`nimport com.fire.adforge.ui.CountdownBanner`nimport com.fire.adforge.backend.CrewBadgeBinder`nimport androidx.compose.material.icons.filled.List
import androidx.compose.ui.Modifier`nimport com.fire.adforge.ui.CountdownBanner`nimport com.fire.adforge.backend.CrewBadgeBinder`nimport androidx.compose.material.icons.filled.List
import androidx.compose.ui.unit.dp`nimport com.fire.adforge.ui.CountdownBanner`nimport com.fire.adforge.backend.CrewBadgeBinder`nimport androidx.compose.material.icons.filled.List

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Zenith Test Screen", style = MaterialTheme.typography.titleLarge)
    }
}
