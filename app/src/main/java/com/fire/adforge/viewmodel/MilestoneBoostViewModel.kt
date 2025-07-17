import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class MilestoneBoostViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()

    fun spendCoinsForBoost(userId: String, coinsToSpend: Int, onComplete: (Boolean) -> Unit) {
        viewModelScope.launch {
            try {
                val boostLog = hashMapOf(
                    "coinsSpent" to coinsToSpend,
                    "timestamp" to System.currentTimeMillis()
                )
                db.collection("users").document(userId)
                    .collection("boost_spend_log")
                    .add(boostLog)
                    .await()
                onComplete(true)
            } catch (e: Exception) {
                onComplete(false)
            }
        }
    }
}

