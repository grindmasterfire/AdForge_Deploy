package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// Data class for summary stats block
data class CrewStats(
    val totalCoins: Int = 0,
    val totalRaffleEntries: Int = 0,
    val grindStreak: Int = 0,
    val rank: Int = 0
)

// Data class for each top contributor
data class CrewMember(
    val name: String = "",
    val coins: Int = 0
)

class CrewViewModel : ViewModel() {
    private val _crewStats = MutableStateFlow(CrewStats())
    val crewStats: StateFlow<CrewStats> = _crewStats

    private val _topContributors = MutableStateFlow<List<CrewMember>>(emptyList())
    val topContributors: StateFlow<List<CrewMember>> = _topContributors

    init {
        loadCrewStats()
        loadTopContributors()
    }

    private fun loadCrewStats() {
        viewModelScope.launch {
            // TODO: Replace with Firestore fetch logic
            _crewStats.value = CrewStats(
                totalCoins = 157000,
                totalRaffleEntries = 89,
                grindStreak = 12,
                rank = 3
            )
        }
    }

    private fun loadTopContributors() {
        viewModelScope.launch {
            // TODO: Replace with Firestore fetch logic
            _topContributors.value = listOf(
                CrewMember("Fire", 55000),
                CrewMember("RogueOne", 31000),
                CrewMember("GrindBot", 27000)
            )
        }
    }
}
