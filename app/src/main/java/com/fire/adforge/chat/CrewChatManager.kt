import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.chat

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

data class ChatMessage(
    val senderId: String = "",
    val senderName: String = "",
    val crewName: String? = null,
    val channel: String = "general",
    val message: String = "",
    val timestamp: Long = System.currentTimeMillis()
)

object CrewChatManager {

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    suspend fun sendMessage(channel: String, message: String) {
        val user = auth.currentUser ?: return
        val senderId = user.uid
        val senderName = user.displayName ?: "Anonymous"
        val crewName = "" // TODO: fetch from UserWall or crew meta

        val chat = ChatMessage(
            senderId = senderId,
            senderName = senderName,
            crewName = crewName,
            channel = channel,
            message = message
        )

        try {
            db.collection("crew_chat").document(channel)
                .collection("messages").add(chat).await()
        } catch (e: Exception) {
            Log.e("CrewChatManager", "Send failed", e)
        }
    }

    suspend fun fetchMessages(channel: String, limit: Long = 50): List<ChatMessage> {
        return try {
            val snapshot = db.collection("crew_chat").document(channel)
                .collection("messages")
                .orderBy("timestamp", com.google.firebase.firestore.Query.Direction.DESCENDING)
                .limit(limit)
                .get().await()

            snapshot.toObjects(ChatMessage::class.java).reversed()
        } catch (e: Exception) {
            Log.e("CrewChatManager", "Fetch failed", e)
            emptyList()
        }
    }
}

