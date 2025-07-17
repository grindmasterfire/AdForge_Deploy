import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.database.FirebaseDatabase

class CoinLedgerViewModel : ViewModel() {
    private val db = FirebaseDatabase.getInstance()

    fun updateCoinBalance(userId: String, delta: Long, reason: String) {
        val userRef = db.getReference("coinBalance/\")
        val ledgerRef = db.getReference("coinLedger/\").push()
        val timestamp = System.currentTimeMillis()

        // Ledger entry
        val log = mapOf(
            "delta" to delta,
            "reason" to reason,
            "timestamp" to timestamp
        )
        ledgerRef.setValue(log)

        // Update balance atomically (add or subtract)
        userRef.get().addOnSuccessListener {
            val current = it.child("coins").getValue(Long::class.java) ?: 0L
            userRef.child("coins").setValue(current + delta)
        }
    }
}

