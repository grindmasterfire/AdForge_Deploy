package com.fire.adforge.ui.crew

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.fire.adforge.viewmodel.CrewViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CrewScreen(viewModel: CrewViewModel = viewModel()) {
    val crewStats by viewModel.crewStats.collectAsState()
    val topMembers by viewModel.topContributors.collectAsState()
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Crew Summary", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(12.dp))
        CrewSummaryBlock(crewStats)
        Spacer(Modifier.height(24.dp))

        Text("Top Contributors", style = MaterialTheme.typography.titleMedium)
        LazyColumn {
            items(topMembers.size) { index ->
                val member = topMembers[index]
                Text("• :  coins")
            }
        }

        Spacer(Modifier.height(24.dp))

        // Invite More Crew button triggers Android share intent with preset message
        Button(onClick = {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_SUBJECT, "Join my crew on AdForge!")
                putExtra(Intent.EXTRA_TEXT, "Use my referral code and earn coins! 👉 https://adforge.app/invite?code=FIRECREW01")
            }
            context.startActivity(Intent.createChooser(intent, "Invite via..."))
        }) {
            Text("📣 Invite More Crew")
        }
    }
}
