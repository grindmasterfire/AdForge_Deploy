import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.data

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import java.util.*

object CoinWallet {
    val coinBalance = MutableStateFlow(0)
    private val db = Firebase.firestore

    fun currentUid(): String {
        return AuthManager.getCurrentUid() // Replace with real UID fetch
    }

    fun spendCoins(amount: Int, reason: String = "generic") {
        val uid = currentUid()
        val newBalance = (coinBalance.value - amount).coerceAtLeast(0)
        coinBalance.value = newBalance

        // Log transaction
        val txId = UUID.randomUUID().toString()
        val tx = mapOf(
            "amount" to -amount,
            "timestamp" to System.currentTimeMillis(),
            "reason" to reason
        )
        db.collection("users")
            .document(uid)
            .collection("coinHistory")
            .document(txId)
            .set(tx)
    }

    fun addCoins(amount: Int, source: String = "generic") {
        val uid = currentUid()
        val newBalance = coinBalance.value + amount
        coinBalance.value = newBalance

        // Log addition
        val txId = UUID.randomUUID().toString()
        val tx = mapOf(
            "amount" to amount,
            "timestamp" to System.currentTimeMillis(),
            "reason" to source
        )
        db.collection("users")
            .document(uid)
            .collection("coinHistory")
            .document(txId)
            .set(tx)
    }
}

