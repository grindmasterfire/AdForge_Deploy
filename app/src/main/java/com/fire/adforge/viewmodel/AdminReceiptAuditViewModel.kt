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

data class AuditEntry(
    val userId: String,
    val raffleId: String,
    val amount: Int,
    val status: String,
    val timestamp: Long?
)

class AdminReceiptAuditViewModel : ViewModel() {
    private val _receipts = MutableStateFlow<List<AuditEntry>>(emptyList())
    val receipts: StateFlow<List<AuditEntry>> = _receipts

    private val db = FirebaseDatabase.getInstance()

    init {
        val payoutRef = db.getReference("payoutQueue")
        val auditList = mutableListOf<AuditEntry>()

        payoutRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(payoutSnap: DataSnapshot) {
                val totalUsers = payoutSnap.childrenCount
                var processed = 0L

                for (userSnap in payoutSnap.children) {
                    val userId = userSnap.key ?: continue
                    val map = userSnap.value as? Map<*, *> ?: continue
                    val raffleId = map["raffleId"] as? String ?: continue
                    val amount = (map["amount"] as? Long)?.toInt() ?: 0
                    val status = map["status"] as? String ?: "pending"

                    val verifiedRef = db.getReference("verifiedClaims/\/\")
                    verifiedRef.addListenerForSingleValueEvent(object : ValueEventListener {
                        override fun onDataChange(verifiedSnap: DataSnapshot) {
                            val timestamp = verifiedSnap.getValue(Long::class.java)
                            auditList.add(AuditEntry(userId, raffleId, amount, status, timestamp))
                            processed++
                            if (processed >= totalUsers) {
                                _receipts.value = auditList.sortedByDescending { it.timestamp ?: 0L }
                            }
                        }
                        override fun onCancelled(error: DatabaseError) {}
                    })
                }
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }
}

