package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fire.adforge.model.CoinLedger
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

@Composable
fun CoinLogScreen(userId: String) {
    val db = FirebaseFirestore.getInstance()
    var ledger by remember { mutableStateOf<List<CoinLedger>>(emptyList()) }

    LaunchedEffect(userId) {
        val snapshot = db.collection("coin_ledger")
            .whereEqualTo("userId", userId)
            .orderBy("timestamp")
            .get()
            .await()
        ledger = snapshot.toObjects(CoinLedger::class.java)
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Coin Activity Log") })
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding).padding(16.dp)) {
            items(ledger) { entry ->
                Column(modifier = Modifier.padding(8.dp)) {
                    Text("Type: ")
                    Text("Amount: ")
                    Text("Source: ")
                    Text("Time: ")
                }
                Divider()
            }
        }
    }
}
