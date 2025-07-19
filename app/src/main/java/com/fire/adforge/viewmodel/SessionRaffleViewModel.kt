package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch

class SessionRaffleViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()

    fun joinRaffle(sessionId: String, userId: String, tickets: Int, coinBalance: Int, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        val entry = mapOf(
            "userId" to userId,
            "tickets" to tickets,
            "coinsUsed" to tickets * 10, // Example: 10 coins per ticket
            "timestamp" to System.currentTimeMillis()
        )

        viewModelScope.launch {
            val ref = db.collection("raffle_sessions").document(sessionId).collection("entries").document(userId)
            ref.set(entry)
                .addOnSuccessListener { onSuccess() }
                .addOnFailureListener { onFailure(it) }
        }
    }
}
