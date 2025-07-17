import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class CashoutViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()

    private val _coinBalance = MutableStateFlow(0)
    val coinBalance: StateFlow<Int> = _coinBalance

    private val _selectedMethod = MutableStateFlow("PayPal")
    val selectedMethod: StateFlow<String> = _selectedMethod

    private val _ageVerified = MutableStateFlow(true)
    val ageVerified: StateFlow<Boolean> = _ageVerified

    fun loadUser(userId: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val snap = db.collection("users").document(userId).get().await()
            _coinBalance.value = snap.getLong("coins")?.toInt() ?: 0
            _ageVerified.value = snap.getBoolean("ageVerified") ?: false
        }
    }

    fun selectMethod(method: String) {
        _selectedMethod.value = method
    }

    fun submitPayout(userId: String, baseAmount: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val method = _selectedMethod.value
            val underage = !_ageVerified.value
            val isPlayPoints = method == "Google Play Points"

            val finalAmount = if (underage && isPlayPoints) {
                (baseAmount * 1.2).toInt()
            } else {
                baseAmount
            }

            val bonusDelta = if (underage && isPlayPoints) finalAmount - baseAmount else 0

            val payout = hashMapOf(
                "method" to method,
                "amount" to finalAmount,
                "timestamp" to System.currentTimeMillis(),
                "bonusApplied" to (underage && isPlayPoints)
            )

            db.collection("users")
                .document(userId)
                .collection("payouts")
                .add(payout)

            if (bonusDelta > 0) {
                val log = hashMapOf(
                    "type" to "PlayPointBonus",
                    "userId" to userId,
                    "deltaCoins" to bonusDelta,
                    "timestamp" to System.currentTimeMillis()
                )
                db.collection("ledger")
                    .document("retainedProfits")
                    .collection("logs")
                    .add(log)
            }
        }
    }
}

