package com.fire.adforge.ui.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fire.adforge.logic.BadgeEvaluator
import com.fire.adforge.model.Badge
import kotlinx.coroutines.launch

@Composable
fun AchievementWall(userId: String) {
    val scope = rememberCoroutineScope()
    var unlocked by remember { mutableStateOf<List<Badge>>(emptyList()) }

    LaunchedEffect(Unit) {
        scope.launch {
            unlocked = BadgeEvaluator.evaluateAll(userId)
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
        Text("🏆 Achievements", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(16.dp))
        unlocked.forEach {
            Card(modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp)) {
                Column(Modifier.padding(16.dp)) {
                    Text(it.label, style = MaterialTheme.typography.titleMedium)
                    Text(it.description, style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}
