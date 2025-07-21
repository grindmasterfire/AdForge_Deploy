package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class BoosterViewModel : ViewModel() {

    private val db = FirebaseFirestore.getInstance()

    private val _earnedCoins = MutableStateFlow(0)
    val earnedCoins: StateFlow<Int> = _earnedCoins

    private val _selectedDiscount = MutableStateFlow(5)
    val selectedDiscount: StateFlow<Int> = _selectedDiscount

    init {
        fetchEarnedCoins("user_test_id") //  Replace with actual auth UID
    }

    private fun fetchEarnedCoins(userId: String) {
        db.collection("wallets").document(userId).get().addOnSuccessListener { doc ->
            val coins = doc.getLong("earnedCoins")?.toInt() ?: 0
            _earnedCoins.value = coins
        }
    }

    fun updateDiscount(percent: Int) {
        if (percent in 5..10) {
            _selectedDiscount.value = percent
        }
    }

    fun applyBooster(): Boolean {
        val cost = 100 //  You can calculate dynamic cost later
        if (_earnedCoins.value < cost) return false

        // Deduct coins in Firebase
        db.collection("wallets").document("user_test_id").update(
            mapOf(
                "earnedCoins" to com.google.firebase.firestore.FieldValue.increment(-cost.toLong()),
                "activeBooster" to _selectedDiscount.value
            )
        )
        return true
    }
}
