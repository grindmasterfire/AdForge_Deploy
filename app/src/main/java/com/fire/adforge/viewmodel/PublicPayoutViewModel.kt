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

data class PublicPayout(val userIdObscured: String, val raffleId: String, val amount: Int)

class PublicPayoutViewModel : ViewModel() {
    private val _payouts = MutableStateFlow<List<PublicPayout>>(emptyList())
    val payouts: StateFlow<List<PublicPayout>> = _payouts

    private val db = FirebaseDatabase.getInstance()

    init {
        val ref = db.getReference("payoutQueue")
        ref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<PublicPayout>()
                for (userSnap in snapshot.children) {
                    val userId = userSnap.key ?: continue
                    val map = userSnap.value as? Map<*, *> ?: continue
                    val status = map["status"] as? String ?: continue
                    if (status != "completed") continue

                    val raffleId = map["raffleId"] as? String ?: "unknown"
                    val amount = (map["amount"] as? Long)?.toInt() ?: 0
                    val obscured = userId.take(3) + "***" + userId.takeLast(2)
                    list.add(PublicPayout(obscured, raffleId, amount))
                }
                _payouts.value = list.sortedByDescending { it.raffleId }
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }
}

