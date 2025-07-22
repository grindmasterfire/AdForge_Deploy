package com.fire.adforge.ui.launch

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onLaunchComplete: () -> Unit) {
    LaunchedEffect(Unit) {
        delay(2000) // 2 second splash
        onLaunchComplete()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.adforge_logo),
                contentDescription = "AdForge Logo",
                modifier = Modifier.size(128.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text("AdForge", style = MaterialTheme.typography.headlineMedium)
            Text("Power by the People  Built by Cipher")
        }
    }
}
