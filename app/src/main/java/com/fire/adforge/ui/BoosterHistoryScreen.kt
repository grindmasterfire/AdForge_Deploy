package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fire.adforge.model.BoosterOffer
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun BoosterHistoryScreen() {
    val uid = FirebaseAuth.getInstance().currentUser?.uid
    var boosters by remember { mutableStateOf<List<BoosterOffer>>(emptyList()) }

    LaunchedEffect(uid) {
        if (uid != null) {
            FirebaseFirestore.getInstance()
                .collection("users")
                .document(uid)
                .collection("boosters")
                .get()
                .addOnSuccessListener { result ->
                    boosters = result.documents.mapNotNull { it.toObject(BoosterOffer::class.java) }
                }
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(20.dp)) {
        Text("🧾 Booster Purchase History", style = MaterialTheme.typography.headlineLarge)
        Spacer(Modifier.height(16.dp))
        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(boosters) { boost ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(boost.title, style = MaterialTheme.typography.titleMedium)
                        Text("Provider: ", style = MaterialTheme.typography.bodySmall)
                        Text("Boost: % | Cost:  coins", style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
    }
}
