import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui.user

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.UserAchievementViewModel

@Composable
fun UserAchievementScreen(vm: UserAchievementViewModel = viewModel()) {
    val achievements by vm.achievements.collectAsState()
    Column(modifier = Modifier.padding(16.dp)) {
        Text(\"User Achievements\", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(achievements) { achievement ->
                Text(achievement, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(vertical = 4.dp))
            }
        }
    }
}

