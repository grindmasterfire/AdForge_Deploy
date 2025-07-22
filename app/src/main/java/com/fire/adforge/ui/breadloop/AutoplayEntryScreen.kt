package com.fire.adforge.ui.breadloop

import android.content.Context
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext

@Composable
fun AutoplayEntryScreen(onProceed: () -> Unit) {
    val context = LocalContext.current
    val accepted = remember {
        context.getSharedPreferences("AdForgePrefs", Context.MODE_PRIVATE)
            .getBoolean("autoplayDisclaimerAccepted", false)
    }

    LaunchedEffect(Unit) {
        if (accepted) {
            onProceed()
        }
    }

    if (!accepted) {
        AutoplayDisclaimerScreen(onAccept = onProceed)
    }
}
