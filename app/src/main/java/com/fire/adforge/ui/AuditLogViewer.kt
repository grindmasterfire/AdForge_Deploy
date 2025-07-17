import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fire.adforge.model.AuditLogEntry
import com.google.firebase.database.*

@Composable
fun AuditLogViewer() {
    val logs = remember { mutableStateListOf<AuditLogEntry>() }

    LaunchedEffect(Unit) {
        val dbRef = FirebaseDatabase.getInstance().getReference("auditLogs")
        dbRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                logs.clear()
                for (raffleSnap in snapshot.children) {
                    for (logSnap in raffleSnap.children) {
                        logSnap.getValue(AuditLogEntry::class.java)?.let {
                            logs.add(it)
                        }
                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {}
        })
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Audit Log Viewer") }) }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(logs) { log ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Raffle ID: \")
                        Text("Action: \")
                        Text("Timestamp: \")
                    }
                }
            }
        }
    }
}

