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
import com.fire.adforge.backend.CrewJoiner
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

@Composable
fun InviteCodePanel(crewId: String) {
    var code by remember { mutableStateOf("Loading...") }
    val scope = rememberCoroutineScope()

    LaunchedEffect(crewId) {
        val doc = FirebaseFirestore.getInstance()
            .collection("crews")
            .document(crewId)
            .get()
            .await()
        code = doc.getString("inviteCode") ?: "Not Generated"
    }

    Card(modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("📨 Invite Code", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Current Code: ")

            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = {
                scope.launch {
                    code = CrewJoiner.generateInviteCode(crewId)
                }
            }) {
                Text("Generate New Code")
            }
        }
    }
}

