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
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun CrewCreateScreen(onCreated: () -> Unit = {}) {
    var crewName by remember { mutableStateOf("") }
    var isPublic by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text("Create a Crew", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = crewName,
            onValueChange = { crewName = it },
            label = { Text("Crew Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))
        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            Checkbox(checked = isPublic, onCheckedChange = { isPublic = it })
            Text("Make crew public")
        }

        errorMessage?.let {
            Spacer(modifier = Modifier.height(8.dp))
            Text(it, color = MaterialTheme.colorScheme.error)
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (crewName.isBlank()) {
                errorMessage = "Crew name cannot be empty"
                return@Button
            }

            CoroutineScope(Dispatchers.IO).launch {
                val db = FirebaseFirestore.getInstance()
                val existing = db.collection("crews")
                    .whereEqualTo("name", crewName)
                    .get()
                    .await()

                if (!existing.isEmpty) {
                    errorMessage = "Crew name already taken"
                    return@launch
                }

                val newCrew = hashMapOf(
                    "name" to crewName,
                    "isPublic" to isPublic,
                    "created" to Timestamp.now(),
                    "memberCount" to 1,
                    "totalCoinsEarned" to 0L
                )

                db.collection("crews").add(newCrew)
                onCreated()
            }
        }) {
            Text("Create Crew")
        }
    }
}

