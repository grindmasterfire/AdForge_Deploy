package com.fire.adforge.ui.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.PersonalWallViewModel
import com.fire.adforge.model.Badge
import kotlinx.coroutines.launch
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

@Composable
fun PersonalWallScreen(userId: String) {
    val vm: PersonalWallViewModel = viewModel()
    val badges by remember { mutableStateOf(mutableListOf<Badge>()) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(userId) {
        coroutineScope.launch {
            badges.clear()
            val snapshot = FirebaseFirestore.getInstance()
                .collection("users")
                .document(userId)
                .collection("badges")
                .get().await()
            badges.addAll(snapshot.toObjects(Badge::class.java))
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Personal Wall", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(12.dp))

        Text(" Badges:", style = MaterialTheme.typography.titleMedium)
        LazyRow(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
            items(badges) { badge ->
                Card(modifier = Modifier.padding(end = 8.dp)) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text(" ")
                        Text("Earned: ")
                    }
                }
            }
        }
    }
}
