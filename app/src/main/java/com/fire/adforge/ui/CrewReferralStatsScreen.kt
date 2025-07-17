import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.CrewStatsViewModel

@Composable
fun CrewReferralStatsScreen(vm: CrewStatsViewModel = viewModel()) {
    val stats by vm.referralStats.collectAsState()
    val milestone by vm.crewMilestoneProgress.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Crew Referral Performance", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(12.dp))
        Text("Monthly Milestone Progress: $milestone%", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn {
            items(stats) { (tier, amount) ->
                Text("Tier $tier: +$amount coins", style = MaterialTheme.typography.bodyMedium)
                Divider()
            }
        }
    }
}

