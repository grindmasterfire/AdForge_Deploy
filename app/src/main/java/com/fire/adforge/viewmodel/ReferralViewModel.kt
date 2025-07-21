package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ReferralViewModel : ViewModel() {

    private val db = FirebaseFirestore.getInstance()
    private val _referralCode = MutableStateFlow<String?>(null)
    val referralCode: StateFlow<String?> = _referralCode

    private val _totalReferralEarnings = MutableStateFlow(0)
    val totalReferralEarnings: StateFlow<Int> = _totalReferralEarnings

    init {
        fetchReferralData("user_test_id") //  Replace with real auth UID
    }

    private fun fetchReferralData(userId: String) {
        db.collection("referrals").document(userId).get().addOnSuccessListener { doc ->
            val code = doc.getString("referralCode")
            val earned = doc.getLong("referralCoins")?.toInt() ?: 0
            _referralCode.value = code
            _totalReferralEarnings.value = earned
        }
    }
}
