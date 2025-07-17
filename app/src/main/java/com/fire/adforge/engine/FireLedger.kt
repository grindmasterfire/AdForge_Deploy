import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.engine

import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

object FireLedger {
    private val db = FirebaseFirestore.getInstance()

    fun recordFireCut(raffleId: String, raffleType: String, pot: Long) {
        val fireShare = pot * 0.10
        val timestamp = System.currentTimeMillis()
        val docId = UUID.randomUUID().toString()

        val entry = mapOf(
            "raffleId" to raffleId,
            "raffleType" to raffleType,
            "fireShare" to fireShare,
            "timestamp" to timestamp
        )

        db.collection("ledger")
            .document("fire")
            .collection("earnings")
            .document(docId)
            .set(entry)
    }
}

