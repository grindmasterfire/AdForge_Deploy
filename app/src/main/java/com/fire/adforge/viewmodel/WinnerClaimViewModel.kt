package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

data class RaffleWinner(
    val userId: String = "",
    val prize: Int = 0,
    val claimed: Boolean = false
)

class WinnerClaimViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()
    private val _winners = MutableStateFlow<List<RaffleWinner>>(emptyList())
    val winners = _winners.asStateFlow()

    fun fetchWinners() {
        db.collection("raffle_winners")
            .get()
            .addOnSuccessListener { result ->
                val list = result.documents.mapNotNull { it.toObject(RaffleWinner::class.java) }
                _winners.value = list
            }
    }

    fun markAsClaimed(userId: String) {
        db.collection("raffle_winners").document(userId)
            .update("claimed", true)
    }
}
