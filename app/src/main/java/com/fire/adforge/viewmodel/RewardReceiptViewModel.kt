import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.database.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class RewardReceipt(
    val raffleId: String,
    val amount: Int,
    val status: String,
    val timestamp: Long?
)

class RewardReceiptViewModel : ViewModel() {
    private val _receipts = MutableStateFlow<List<RewardReceipt>>(emptyList())
    val receipts: StateFlow<List<RewardReceipt>> = _receipts

    private val db = FirebaseDatabase.getInstance()
    private val userId = "testUser" // Replace with live user ID logic

    init {
        val queueRef = db.getReference("payoutQueue/\")

        queueRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(queueSnap: DataSnapshot) {
                val map = queueSnap.value as? Map<*, *> ?: return
                val raffleId = map["raffleId"] as? String ?: return
                val amount = (map["amount"] as? Long)?.toInt() ?: return
                val status = map["status"] as? String ?: "pending"

                val verifiedRef = db.getReference("verifiedClaims/\/\")
                verifiedRef.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(verifiedSnap: DataSnapshot) {
                        val timestamp = verifiedSnap.getValue(Long::class.java)
                        val receipt = RewardReceipt(raffleId, amount, status, timestamp)
                        _receipts.value = listOf(receipt)
                    }

                    override fun onCancelled(error: DatabaseError) {}
                })
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }
}

