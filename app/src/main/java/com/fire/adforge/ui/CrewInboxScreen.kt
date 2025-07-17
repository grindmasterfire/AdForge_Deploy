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
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

data class MailMessage(
    val sender: String = "",
    val type: String = "",
    val subject: String = "",
    val content: String = "",
    val timestamp: Timestamp = Timestamp.now(),
    val read: Boolean = false
)

@Composable
fun CrewInboxScreen() {
    val db = FirebaseFirestore.getInstance()
    val userId = FirebaseAuth.getInstance().currentUser?.uid ?: return
    var messages by remember { mutableStateOf<List<MailMessage>>(emptyList()) }

    LaunchedEffect(Unit) {
        val snap = db.collection("mail")
            .document(userId)
            .collection("messages")
            .orderBy("timestamp", com.google.firebase.firestore.Query.Direction.DESCENDING)
            .get()
            .await()

        messages = snap.documents.mapNotNull { it.toObject(MailMessage::class.java) }
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text("📨 Crew Inbox", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(messages) { msg ->
                Card {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(msg.subject, style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(msg.content)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text("From:  | ", style = MaterialTheme.typography.labelSmall)
                    }
                }
            }
        }
    }
}

