import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RaffleCooldownViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()
    private val _remaining = MutableStateFlow(0L)
    val remaining: StateFlow<Long> get() = _remaining

    fun checkCooldown(userId: String, raffleType: String) {
        viewModelScope.launch {
            val doc = db.collection("users").document(userId)
                .collection("cooldowns").document(raffleType).get().await()
            val cooldownEnd = doc.getLong("endsAt") ?: 0L
            val now = System.currentTimeMillis()
            _remaining.value = (cooldownEnd - now).coerceAtLeast(0L)
        }
    }
}

