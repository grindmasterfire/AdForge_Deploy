import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fire.adforge.social.Crew
import com.fire.adforge.social.CrewManager

@Composable
fun CrewScreen() {
    val sampleCrew = Crew("FireStarter", listOf("Fire", "Cipher", "Ash"), "Fire")
    LaunchedEffect(Unit) {
        CrewManager.addCrew(sampleCrew)
    }

    val crews = remember { mutableStateOf(CrewManager.getAllCrews()) }

    Column(modifier = Modifier.padding(24.dp)) {
        Text("Crews", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(16.dp))
        crews.value.forEach { crew ->
            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)) {
                Column(Modifier.padding(12.dp)) {
                    Text("Crew: ")
                    Text("Leader: ")
                    Text("Members: ")
                }
            }
        }
    }
}

