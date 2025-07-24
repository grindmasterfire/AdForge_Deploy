package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class DailyEarning(
    val date: String,
    val amount: Int
)

class EarningsTrendViewModel : ViewModel() {
    private val _dailyEarnings = MutableStateFlow<List<DailyEarning>>(emptyList())
    val dailyEarnings: StateFlow<List<DailyEarning>> = _dailyEarnings

    private val db = FirebaseFirestore.getInstance()
    private val userId = "demoUser"

    init {
        loadEarnings()
    }

    private fun loadEarnings() {
        viewModelScope.launch {
            db.collection("users").document(userId)
                .collection("earning_summary")
                .get()
                .addOnSuccessListener { result ->
                    val summary = result.map { doc ->
                        DailyEarning(
                            date = doc.id,
                            amount = (doc.getLong("totalCoins") ?: 0).toInt()
                        )
                    }.sortedBy { it.date }
                    _dailyEarnings.value = summary
                }
        }
    }
}
