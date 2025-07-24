package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class CrewGrindEntry(
    val username: String = "",
    val coins: Int = 0
)

class CrewGrindViewModel : ViewModel() {
    private val _crewGrind = MutableStateFlow<List<CrewGrindEntry>>(emptyList())
    val crewGrind: StateFlow<List<CrewGrindEntry>> = _crewGrind

    val raffleThreshold = 200 // Forecast cutoff for private raffle eligibility

    private val db = FirebaseFirestore.getInstance()
    private val crewId = "demoCrew" // Replace in production

    init {
        loadCrewGrind()
    }

    private fun loadCrewGrind() {
        viewModelScope.launch {
            db.collection("crews").document(crewId)
                .collection("grind_log")
                .get()
                .addOnSuccessListener { result ->
                    val list = result.map { doc ->
                        CrewGrindEntry(
                            username = doc.getString("username") ?: "unknown",
                            coins = (doc.getLong("coins") ?: 0).toInt()
                        )
                    }.sortedByDescending { it.coins }
                    _crewGrind.value = list
                }
        }
    }
}
