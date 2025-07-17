package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MailViewModel : ViewModel() {
    private val _messages = MutableStateFlow<List<String>>(emptyList())
    val messages: StateFlow<List<String>> = _messages

    init {
        loadMessages()
    }

    fun loadMessages() {
        // TODO: Fetch messages from Firestore inbox
    }
}
