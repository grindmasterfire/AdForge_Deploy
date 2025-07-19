package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

data class PayoutRequest(
    val userId: String = "",
    val method: String = "",
    val amount: Int = 0,
    val status: String = "pending"
)

class PayoutQueueViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()
    private val _queue = MutableStateFlow<List<PayoutRequest>>(emptyList())
    val queue = _queue.asStateFlow()

    fun fetchPayoutQueue() {
        db.collection("payout_queue")
            .get()
            .addOnSuccessListener { result ->
                val list = result.documents.mapNotNull { it.toObject(PayoutRequest::class.java) }
                _queue.value = list
            }
    }

    fun updatePayoutStatus(userId: String, newStatus: String) {
        db.collection("payout_queue").document(userId)
            .update("status", newStatus)
    }
}
