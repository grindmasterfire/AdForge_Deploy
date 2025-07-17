import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.CrewViewModel

@Composable
fun CrewScreen(viewModel: CrewViewModel = viewModel()) {
    val crewName by viewModel.crewName.collectAsState()
    val isInCrew by viewModel.isInCrew.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        if (isInCrew) {
            Text("You are in: \")
        } else {
            OutlinedTextField(
                value = crewName,
                onValueChange = { viewModel.updateCrewName(it) },
                label = { Text("Enter Crew Name") }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { viewModel.createOrJoinCrew() }) {
                Text("Create or Join Crew")
            }
        }
    }
}

