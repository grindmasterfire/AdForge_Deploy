import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.CrewAchievementsViewModel
import com.fire.adforge.viewmodel.CrewAchievement

@Composable
fun CrewAchievementsScreen(crewId: String, vm: CrewAchievementsViewModel = viewModel(factory = object : androidx.lifecycle.ViewModelProvider.Factory {
    override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
        return CrewAchievementsViewModel(crewId) as T
    }
})) {
    val achievements by vm.achievements.collectAsState()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text(
            text = "🏆 Crew Contributions",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(achievements.values.sortedByDescending { it.coinsEarned }) { achievement ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text("User: ", style = MaterialTheme.typography.titleSmall)
                        Text("Coins Earned: ")
                        Text("Offers Completed: ")
                        Text("Raffle Tickets: ")
                    }
                }
            }
        }
    }
}

