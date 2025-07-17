import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import com.fire.adforge.model.ChatMessage
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ChatViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()
    private val _messages = MutableStateFlow<List<ChatMessage>>(emptyList())
    val messages: StateFlow<List<ChatMessage>> = _messages

    fun listenToChannel(channel: String) {
        db.collection("chats").document(channel)
            .collection("messages")
            .orderBy("timestamp")
            .addSnapshotListener { snapshots, _ ->
                val msgs = snapshots?.toObjects(ChatMessage::class.java) ?: emptyList()
                _messages.value = msgs
            }
    }

    fun sendMessage(sender: String, message: String, channel: String) {
        val msg = ChatMessage(sender = sender, message = message, channel = channel)
        db.collection("chats").document(channel)
            .collection("messages")
            .add(msg)
    }
}

