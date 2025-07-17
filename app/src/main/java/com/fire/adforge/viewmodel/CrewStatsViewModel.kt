import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.google.firebase.firestore.FirebaseFirestore

class CrewStatsViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()
    private val crewId = "demoCrew" // Replace with dynamic ID logic

    private val _referralStats = MutableStateFlow<Map<Int, Int>>(emptyMap())
    val referralStats: StateFlow<Map<Int, Int>> = _referralStats

    private val _crewMilestoneProgress = MutableStateFlow(0)
    val crewMilestoneProgress: StateFlow<Int> = _crewMilestoneProgress

    init {
        loadStats()
    }

    private fun loadStats() {
        viewModelScope.launch {
            val result = mutableMapOf<Int, Int>()
            for (tier in 1..4) {
                db.collection("crews").document(crewId)
                    .collection("referrals").document("tier\")
                    .get().addOnSuccessListener {
                        val coins = it.getLong("totalCoins")?.toInt() ?: 0
                        result[tier] = coins
                        _referralStats.value = result.toSortedMap()
                    }
            }

            db.collection("crews").document(crewId)
                .get().addOnSuccessListener {
                    val progress = it.getLong("milestoneProgress")?.toInt() ?: 0
                    _crewMilestoneProgress.value = progress
                }
        }
    }
}

