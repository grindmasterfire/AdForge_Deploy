package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CashoutViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()
    private val userId = "demoUser"

    val selectedMethod = MutableStateFlow("PayPal")
    val coinBalance = MutableStateFlow(0)
    val statusMessage = MutableStateFlow("")

    init {
        fetchCoinBalance()
    }

    fun onSelectMethod(method: String) {
        selectedMethod.value = method
    }

    private fun fetchCoinBalance() {
        viewModelScope.launch {
            db.collection("users").document(userId)
                .get()
                .addOnSuccessListener { doc ->
                    val coins = doc.getLong("walletCoins")?.toInt() ?: 0
                    coinBalance.value = coins
                }
        }
    }

    fun initiateCashout(pinOrAnswer: String) {
        if (pinOrAnswer.length < 4) {
            statusMessage.value = "PIN/Answer too short."
            return
        }

        viewModelScope.launch {
            val coins = coinBalance.value
            if (coins < 1000) {
                statusMessage.value = "Minimum 1000 coins required."
                return@launch
            }

            val payload = mapOf(
                "userId" to userId,
                "method" to selectedMethod.value,
                "amount" to coins,
                "timestamp" to Timestamp.now(),
                "auth" to pinOrAnswer
            )

            db.collection("withdrawal_log").add(payload).addOnSuccessListener {
                db.collection("users").document(userId).update("walletCoins", 0)
                coinBalance.value = 0
                statusMessage.value = "Cashout request sent!"
            }.addOnFailureListener {
                statusMessage.value = "Failed to process request."
            }
        }
    }
}
