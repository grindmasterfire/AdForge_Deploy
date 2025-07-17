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
fun LegalConsentScreen(onAccept: () -> Unit) {
    val context = LocalContext.current
    var terms by remember { mutableStateOf("") }
    var privacy by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        context.assets.open("terms_of_service.txt").use {
            terms = BufferedReader(InputStreamReader(it)).readText()
        }
        context.assets.open("privacy_policy.txt").use {
            privacy = BufferedReader(InputStreamReader(it)).readText()
        }
    }

    Column(modifier = Modifier
        .padding(24.dp)
        .verticalScroll(rememberScrollState())) {
        Text("📄 Terms of Service", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(8.dp))
        Text(terms)

        Spacer(Modifier.height(24.dp))

        Text("🔒 Privacy Policy", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(8.dp))
        Text(privacy)

        Spacer(Modifier.height(24.dp))
        Button(onClick = onAccept) {
            Text("✅ Accept & Continue")
        }
    }
}
