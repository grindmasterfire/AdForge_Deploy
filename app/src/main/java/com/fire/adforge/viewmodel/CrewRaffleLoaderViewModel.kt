package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

data class CrewRaffle(
    val crewName: String = "",
    val totalTickets: Int = 0,
    val topUser: String = ""
)

class CrewRaffleLoaderViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()
    private val _raffles = MutableStateFlow<List<CrewRaffle>>(emptyList())
    val raffles = _raffles.asStateFlow()

    fun fetchCrewRaffles() {
        db.collection("crew_raffles")
            .get()
            .addOnSuccessListener { result ->
                val list = result.documents.mapNotNull { it.toObject(CrewRaffle::class.java) }
                _raffles.value = list
            }
    }
}

// ✅ Kit214: Final crew patch marker — lifecycle segment sealed
