import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

data class CrewSummary(
    val crewId: String = "",
    val name: String = "",
    val memberCount: Int = 0,
    val totalCoins: Long = 0
)

@Composable
fun CrewListScreen(onCrewSelected: (String) -> Unit = {}) {
    var crews by remember { mutableStateOf<List<CrewSummary>>(emptyList()) }

    LaunchedEffect(true) {
        val snapshot = FirebaseFirestore.getInstance()
            .collection("crews")
            .whereEqualTo("isPublic", true)
            .get()
            .await()

        crews = snapshot.documents.mapNotNull { doc ->
            val id = doc.id
            val name = doc.getString("name") ?: return@mapNotNull null
            val count = (doc.getLong("memberCount") ?: 0).toInt()
            val coins = doc.getLong("totalCoinsEarned") ?: 0L
            CrewSummary(id, name, count, coins)
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("?? Join a Crew", style = MaterialTheme.typography.titleLarge)

        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(crews) { crew ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onCrewSelected(crew.crewId) }
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
    Button(onClick = {
        kotlinx.coroutines.CoroutineScope(kotlinx.coroutines.Dispatchers.IO).launch {
            val result = CrewJoiner.joinCrew(crew.crewId)
            println("Join result: \")
        }
    }) {
        Text("Join Crew")
    }
                        Text(crew.name, style = MaterialTheme.typography.titleMedium)
                        Text("Members: ")
                        Text("Total Coins: ")
                    }
                }
            }
        }
    }
}


