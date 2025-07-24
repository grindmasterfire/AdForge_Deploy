package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class RaffleResult(
    val timestamp: String = "",
    val raffleId: String = "",
    val ticketType: String = "",
    val place: String = "",
    val coinsWon: Int = 0
)

class RaffleResultsViewModel : ViewModel() {
    private val _raffleResults = MutableStateFlow<List<RaffleResult>>(emptyList())
    val raffleResults: StateFlow<List<RaffleResult>> = _raffleResults

    private val db = FirebaseFirestore.getInstance()
    private val userId = "demoUser"

    init {
        fetchResults()
    }

    private fun fetchResults() {
        viewModelScope.launch {
            db.collection("raffle_ledger")
                .whereEqualTo("userId", userId)
                .get()
                .addOnSuccessListener { result ->
                    val list = result.map { doc ->
                        RaffleResult(
                            timestamp = doc.getTimestamp("timestamp")?.toDate().toString(),
                            raffleId = doc.getString("raffleId") ?: "",
                            ticketType = doc.getString("ticketType") ?: "UNKNOWN",
                            place = doc.getString("place") ?: "-",
                            coinsWon = (doc.getLong("coins") ?: 0).toInt()
                        )
                    }
                    _raffleResults.value = list.sortedByDescending { it.timestamp }
                }
        }
    }
}
