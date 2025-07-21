package com.fire.adforge.ui.crew

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.CrewViewModel

@Composable
fun CrewDashboard(viewModel: CrewViewModel = viewModel()) {
    val crew by viewModel.userCrew.collectAsState()
    val context = LocalContext.current
    val multiplier = viewModel.calculateCrewMultiplier()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Crew Dashboard", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(20.dp))

        Text("Crew Name: ")
        Spacer(modifier = Modifier.height(8.dp))

        Text("Grind Total: ")
        Spacer(modifier = Modifier.height(8.dp))

        Text("Multiplier: x")
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            viewModel.leaveCrew("user_test_id") //  Replace with real user ID
            Toast.makeText(context, "You left the crew.", Toast.LENGTH_SHORT).show()
        }) {
            Text("Leave Crew")
        }
    }
}
