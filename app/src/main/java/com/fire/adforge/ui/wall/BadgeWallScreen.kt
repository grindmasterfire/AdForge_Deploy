package com.fire.adforge.ui.wall

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.CrewBadgeViewModel

@Composable
fun BadgeWallScreen() {
    val vm = viewModel<CrewBadgeViewModel>()
    val badges = vm.badges.collectAsState().value
    val unlocked = vm.unlockedTimestamps.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("🎖️ Your Badge Wall", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(12.dp))

        if (badges.isEmpty()) {\n            Text("You have no badges yet. Start earning to unlock achievements!")\n        } else badges.forEach { badge ->
            Column(modifier = Modifier.padding(vertical = 6.dp)) {
                Text("🏅 ", style = MaterialTheme.typography.bodyMedium)
                val ts = unlocked[badge.id] ?: 0L
                if (ts > 0L) {
                    val date = java.text.SimpleDateFormat("yyyy-MM-dd").format(java.util.Date(ts))
                    Text("Unlocked on ", style = MaterialTheme.typography.labelSmall)
                }
            }
        }
    }
}
