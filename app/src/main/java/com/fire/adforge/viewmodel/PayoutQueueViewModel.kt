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

data class PayoutEntry(val userId: String, val raffleId: String, val amount: Int, val status: String)

class PayoutQueueViewModel : ViewModel() {
    private val _queue = MutableStateFlow<List<PayoutEntry>>(emptyList())
    val queue: StateFlow<List<PayoutEntry>> = _queue

    private val db = FirebaseDatabase.getInstance()

    init {
        val payoutRef = db.getReference("payoutQueue")

        payoutRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<PayoutEntry>()
                for (userSnap in snapshot.children) {
                    val userId = userSnap.key ?: continue
                    val map = userSnap.value as? Map<*, *> ?: continue
                    val raffleId = map["raffleId"] as? String ?: "unknown"
                    val amount = (map["amount"] as? Long)?.toInt() ?: 0
                    val status = map["status"] as? String ?: "pending"
                    list.add(PayoutEntry(userId, raffleId, amount, status))
                }
                _queue.value = list
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }

    fun markAsPaid(userId: String) {
        db.getReference("payoutQueue/\/status").setValue("completed")
    }
}

