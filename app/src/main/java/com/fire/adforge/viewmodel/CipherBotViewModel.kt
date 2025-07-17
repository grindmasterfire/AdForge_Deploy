import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CipherBotViewModel : ViewModel() {
    private val _botMessages = MutableStateFlow<List<String>>(emptyList())
    val botMessages: StateFlow<List<String>> = _botMessages

    fun addBotMessage(message: String) {
        _botMessages.value = _botMessages.value + message
    }
}

