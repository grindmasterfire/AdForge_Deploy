import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

@Composable
fun CrewInfoPanel(crewId: String) {
    var crewName by remember { mutableStateOf("Loading...") }
    var memberCount by remember { mutableStateOf(0) }
    var totalCoins by remember { mutableStateOf(0L) }

    LaunchedEffect(crewId) {
        val doc = FirebaseFirestore.getInstance()
            .collection("crews")
            .document(crewId)
            .get()
            .await()

        crewName = doc.getString("name") ?: "Unnamed Crew"
        memberCount = (doc.getLong("memberCount") ?: 0).toInt()
        totalCoins = doc.getLong("totalCoinsEarned") ?: 0
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = android.R.drawable.sym_def_app_icon),
                contentDescription = "Crew Avatar",
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(crewName, style = MaterialTheme.typography.titleMedium)
                Text("Members: ")
                Text("Total Coins: ")
            }
        }
    }
}

