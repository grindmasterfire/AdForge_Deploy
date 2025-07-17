import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun QACommandDeckScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top)
    ) {
        Text("🧪 QA Command Deck", style = MaterialTheme.typography.headlineLarge)

        Divider(modifier = Modifier.padding(vertical = 16.dp))

        Button(onClick = { navController.navigate("qaDevice") }) {
            Text("Run QA Device Harness")
        }

        Button(onClick = { navController.navigate("raffleSanity") }) {
            Text("Run Raffle Sanity Test")
        }

        // Future test routes can go here
    }
}

