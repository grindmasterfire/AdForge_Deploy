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

data class RaffleRecord(
    val raffleId: String,
    val timestamp: Long,
    val entryCount: Int,
    val totalPaid: Int
)

class RaffleJournalViewModel : ViewModel() {
    private val _journal = MutableStateFlow<List<RaffleRecord>>(emptyList())
    val journal: StateFlow<List<RaffleRecord>> = _journal

    private val db = FirebaseDatabase.getInstance()

    init {
        val ref = db.getReference("raffleJournal")
        ref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<RaffleRecord>()
                for (raffleSnap in snapshot.children) {
                    val raffleId = raffleSnap.key ?: continue
                    val data = raffleSnap.value as? Map<*, *> ?: continue
                    val timestamp = (data["timestamp"] as? Long) ?: continue
                    val entryCount = (data["entryCount"] as? Long)?.toInt() ?: 0
                    val totalPaid = (data["totalPaid"] as? Long)?.toInt() ?: 0

                    list.add(RaffleRecord(raffleId, timestamp, entryCount, totalPaid))
                }
                _journal.value = list.sortedByDescending { it.timestamp }
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }
}

