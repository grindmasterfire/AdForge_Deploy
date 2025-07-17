package com.fire.adforge.ui.wall

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import coil.compose.rememberAsyncImagePainter
import com.fire.adforge.models.UserWallMeta

@Composable
fun UserWallScreen(meta: UserWallMeta) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberAsyncImagePainter(meta.avatarUrl),
            contentDescription = "User Avatar",
            modifier = Modifier.size(96.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text("Crew: ", style = MaterialTheme.typography.labelLarge)
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            if (meta.currentGrindStatus) "🔥 Grinding Now" else "💤 Offline",
            fontWeight = FontWeight.Bold,
            color = if (meta.currentGrindStatus) Color.Green else Color.LightGray
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text("Achievements: ", style = MaterialTheme.typography.labelMedium)
    }
}
