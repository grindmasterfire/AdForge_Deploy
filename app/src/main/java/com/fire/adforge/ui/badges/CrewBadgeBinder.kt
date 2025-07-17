package com.fire.adforge.ui.badges

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fire.adforge.models.CrewBadgeMeta

@Composable
fun CrewBadgeBinder(badges: List<CrewBadgeMeta>) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Crew Badges", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        badges.forEach { badge ->
            Text(badge.name + if (badge.id == "alpha_founder") " 🌟" else "", style = MaterialTheme.typography.bodySmall)\r\n                        if (badge.id == "alpha_founder") Text("1st 1K users", style = MaterialTheme.typography.labelSmall)\r\n                        val ts = vm.unlockedTimestamps.collectAsState().value[badge.id] ?: 0L\r\n                        if (ts > 0L) Text("Unlocked: " + java.text.SimpleDateFormat("MMM dd").format(java.util.Date(ts)), style = MaterialTheme.typography.labelSmall)
            if (badge.earned) {
                Text("Unlocked: " + java.text.SimpleDateFormat("MMM dd").format(java.util.Date(badge.unlockedTimestamp)), style = MaterialTheme.typography.labelSmall)
            } else {
                Text("Locked", style = MaterialTheme.typography.labelSmall)
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
