package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.tasks.await

data class RaffleEntry(
    val userId: String = "",
    val tickets: Int = 0,
    val coinsUsed: Int = 0
)

class SessionRaffleEntryViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()
    private val _entries = MutableStateFlow<List<RaffleEntry>>(emptyList())
    val entries = _entries.asStateFlow()

    fun loadEntries(sessionId: String) {
        db.collection("raffle_sessions").document(sessionId).collection("entries")
            .get()
            .addOnSuccessListener { result ->
                val loaded = result.documents.mapNotNull { it.toObject(RaffleEntry::class.java) }
                _entries.value = loaded
            }
    }
}
