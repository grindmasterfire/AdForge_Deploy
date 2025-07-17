import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.wallet

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

data class CoinTransaction(
    val userId: String = "",
    val source: String = "",
    val amount: Int = 0,
    val timestamp: Long = System.currentTimeMillis(),
    val context: String? = null
)

object CoinAuditLog {

    private val db = FirebaseFirestore.getInstance()

    suspend fun logCoinGain(userId: String, amount: Int, source: String, context: String? = null) {
        try {
            val entry = CoinTransaction(
                userId = userId,
                amount = amount,
                source = source,
                context = context
            )
            db.collection("coin_audit").add(entry).await()
        } catch (e: Exception) {
            Log.e("CoinAuditLog", "Failed to log gain", e)
        }
    }

    suspend fun logCoinSpend(userId: String, amount: Int, context: String? = null) {
        logCoinGain(userId, -amount, "spend", context)
    }
}

