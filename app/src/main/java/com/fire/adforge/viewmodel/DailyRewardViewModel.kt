package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.text.SimpleDateFormat
import java.util.*

class DailyRewardViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()
    private val _hasClaimed = MutableStateFlow(false)
    val hasClaimed = _hasClaimed.asStateFlow()

    private fun todayKey(): String {
        val date = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
        return "daily_\"
    }

    fun checkIfClaimed(userId: String) {
        db.collection("daily_rewards").document(userId)
            .get()
            .addOnSuccessListener { doc ->
                _hasClaimed.value = doc.contains(todayKey())
            }
    }

    fun claimReward(userId: String, onSuccess: () -> Unit) {
        val key = todayKey()
        db.collection("daily_rewards").document(userId)
            .update(key, true)
            .addOnSuccessListener {
                _hasClaimed.value = true
                onSuccess()
            }
            .addOnFailureListener {
                db.collection("daily_rewards").document(userId)
                    .set(mapOf(key to true))
                    .addOnSuccessListener {
                        _hasClaimed.value = true
                        onSuccess()
                    }
            }
    }
}

// ✅ Kit225: Daily reward lifecycle sealed — no further edits pending
