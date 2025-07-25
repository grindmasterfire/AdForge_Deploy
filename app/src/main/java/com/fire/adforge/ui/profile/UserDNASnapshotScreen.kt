package com.fire.adforge.ui.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.UserDNAViewModel

@Composable
fun UserDNASnapshotScreen(userId: String) {
    val vm: UserDNAViewModel = viewModel()
    val profile by vm.dna.collectAsState()

    LaunchedEffect(userId) {
        vm.loadUserDNA(userId)
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(" User DNA Snapshot", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(12.dp))
        Text("Username: ")
        Text("Total Coins: ")
        Text("Crew: ")
        Text("Referral Reach:  users")
        Text("Badges: ")
        Text("Join Date: ")
        Text("Milestones Completed: ")
        Spacer(Modifier.height(12.dp))
        Text(" Legacy Profile: ")
    }
}
