import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fire.adforge.ui.InviteCodePanel
import com.fire.adforge.viewmodel.CrewAchievementsViewModel

@Composable
fun CrewDashboardScreen(crewId: String) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text("?? Crew Dashboard", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(12.dp))

        CrewInfoPanel(crewId = crewId)\n        InviteCodePanel(crewId = crewId)
        Spacer(modifier = Modifier.height(24.dp))

        Text("Leaderboard", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))

        CrewAchievementsScreen(crewId = crewId)
    }
}


