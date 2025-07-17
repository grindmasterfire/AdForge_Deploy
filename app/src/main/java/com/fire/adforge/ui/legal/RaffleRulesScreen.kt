package com.fire.adforge.ui.legal

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import java.io.BufferedReader
import java.io.InputStreamReader

@Composable
fun RaffleRulesScreen() {
    val context = LocalContext.current
    var text by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        val assetManager = context.assets
        val stream = assetManager.open("raffle_rules_amoe.txt")
        val reader = BufferedReader(InputStreamReader(stream))
        text = reader.readText()
        reader.close()
    }

    Column(modifier = Modifier
        .padding(24.dp)
        .verticalScroll(rememberScrollState())) {
        Text("📜 Raffle Rules & AMOE", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(16.dp))
        Text(text)
    }
}
