package com.fire.adforge.ui

import androidx.compose.foundation.layout.*`nimport com.fire.adforge.ui.CountdownBanner`nimport com.fire.adforge.backend.CrewBadgeBinder
import androidx.compose.material3.*`nimport com.fire.adforge.ui.CountdownBanner`nimport com.fire.adforge.backend.CrewBadgeBinder
import androidx.compose.runtime.*`nimport com.fire.adforge.ui.CountdownBanner`nimport com.fire.adforge.backend.CrewBadgeBinder
import androidx.compose.ui.Alignment`nimport com.fire.adforge.ui.CountdownBanner`nimport com.fire.adforge.backend.CrewBadgeBinder
import androidx.compose.ui.Modifier`nimport com.fire.adforge.ui.CountdownBanner`nimport com.fire.adforge.backend.CrewBadgeBinder
import androidx.compose.ui.unit.dp`nimport com.fire.adforge.ui.CountdownBanner`nimport com.fire.adforge.backend.CrewBadgeBinder

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
