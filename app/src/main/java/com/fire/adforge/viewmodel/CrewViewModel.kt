package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.fire.adforge.model.Crew
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CrewViewModel : ViewModel() {

    private val db = FirebaseFirestore.getInstance()
    private val _userCrew = MutableStateFlow<Crew?>(null)
    val userCrew: StateFlow<Crew?> = _userCrew

    fun fetchUserCrew(userId: String) {
        db.collection("crews")
            .whereArrayContains("members", userId)
            .limit(1)
            .get()
            .addOnSuccessListener { documents ->
                if (!documents.isEmpty) {
                    val crew = documents.first().toObject(Crew::class.java)
                    _userCrew.value = crew
                } else {
                    _userCrew.value = null
                }
            }
    }

    fun createCrew(userId: String, crewName: String) {
        val newCrewRef = db.collection("crews").document()
        val crew = Crew(
            crewId = newCrewRef.id,
            crewName = crewName,
            leaderId = userId,
            members = listOf(userId)
        )
        newCrewRef.set(crew)
    }

    fun leaveCrew(userId: String) {
        _userCrew.value?.let { crew ->
            val updatedMembers = crew.members.filterNot { it == userId }
            val updatedCrew = crew.copy(members = updatedMembers)
            db.collection("crews").document(crew.crewId).set(updatedCrew)
        }
    }

    fun updateGrindPoints(userId: String, points: Int) {
        _userCrew.value?.let { crew ->
            val updatedGrind = crew.totalGrind + points
            db.collection("crews").document(crew.crewId)
                .update("totalGrind", updatedGrind)
        }
    }

    fun calculateCrewMultiplier(): Double {
        val grind = _userCrew.value?.totalGrind ?: return 1.0
        return when {
            grind >= 10000 -> 1.20
            grind >= 5000 -> 1.15
            grind >= 1000 -> 1.10
            grind >= 100 -> 1.05
            else -> 1.0
        }
    }
}
