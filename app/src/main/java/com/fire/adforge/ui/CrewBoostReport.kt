import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun CrewBoostReport(crewId: String) {
    val db = FirebaseFirestore.getInstance()
    var boosts by remember { mutableStateOf(listOf<Pair<String, Int>>()) }

    LaunchedEffect(Unit) {
        db.collection("crews").document(crewId)
            .collection("members").get().addOnSuccessListener { members ->
                val result = mutableListOf<Pair<String, Int>>()
                members.forEach { doc ->
                    val uid = doc.id
                    db.collectionGroup("logs")
                        .whereEqualTo("userId", uid)
                        .get().addOnSuccessListener { logs ->
                            val total = logs.sumOf { it.getLong("coinsSpent")?.toInt() ?: 0 }
                            result.add(uid to total)
                            boosts = result.sortedByDescending { it.second }
                        }
                }
            }
    }

    Column(Modifier.fillMaxSize().padding(12.dp)) {
        Text("Crew Boost Impact", style = MaterialTheme.typography.titleLarge)
        LazyColumn {
            items(boosts) { (user, coins) ->
                Text("$user: $coins coins boosted")
            }
        }
    }
}

