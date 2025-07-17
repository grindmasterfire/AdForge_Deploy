import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.engine

import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

object CipherBotWallet {
    private val db = FirebaseFirestore.getInstance()

    fun logRaffleRetention(raffleId: String, raffleType: String, pot: Long) {
        val retained = pot * 0.15
        val timestamp = System.currentTimeMillis()
        val docId = UUID.randomUUID().toString()

        val entry = mapOf(
            "raffleId" to raffleId,
            "raffleType" to raffleType,
            "retainedAmount" to retained,
            "timestamp" to timestamp
        )

        db.collection("ledger")
            .document("cipherbot")
            .collection("funds")
            .document(docId)
            .set(entry)
    }
}

