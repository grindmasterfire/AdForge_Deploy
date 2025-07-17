package com.fire.adforge.ui.settings

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fire.adforge.backend.SettingsManager
import com.fire.adforge.model.UserSettings
import kotlinx.coroutines.launch

@Composable
fun SettingsScreen(userId: String) {
    val scope = rememberCoroutineScope()
    var settings by remember { mutableStateOf(UserSettings()) }

    LaunchedEffect(Unit) {
        scope.launch {
            settings = SettingsManager.fetchSettings(userId)
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
        Text("⚙️ User Settings", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(16.dp))

        SettingToggle("Enable Autoplay", settings.autoplayEnabled) {
            settings = settings.copy(autoplayEnabled = it)
        }

        SettingToggle("Appear in Crew Chat", settings.showInCrewChat) {
            settings = settings.copy(showInCrewChat = it)
        }

        SettingToggle("Use Dark Mode", settings.darkMode) {
            settings = settings.copy(darkMode = it)
        }

        Spacer(Modifier.height(24.dp))
        Button(onClick = {
            scope.launch {
                SettingsManager.updateSettings(userId, settings)
            }
        }) {
            Text("💾 Save Settings")
        }
    }
}

@Composable
fun SettingToggle(label: String, value: Boolean, onChange: (Boolean) -> Unit) {
    Row(Modifier.fillMaxWidth().padding(vertical = 8.dp), Arrangement.SpaceBetween) {
        Text(label)
        Switch(checked = value, onCheckedChange = onChange)
    }
}
