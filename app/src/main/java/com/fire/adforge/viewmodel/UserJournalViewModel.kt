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

data class UserRaffleSummary(
    val raffleId: String,
    val timestamp: Long?,
    val entryCount: Int?,
    val totalPaid: Int?
)

class UserJournalViewModel : ViewModel() {
    private val _raffles = MutableStateFlow<List<UserRaffleSummary>>(emptyList())
    val raffles: StateFlow<List<UserRaffleSummary>> = _raffles

    private val db = FirebaseDatabase.getInstance()
    private val userId = "testUser" // Replace with dynamic user ID logic

    init {
        val claimsRef = db.getReference("verifiedClaims")
        val journalRef = db.getReference("raffleJournal")
        val matched = mutableListOf<UserRaffleSummary>()

        claimsRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val raffleIds = snapshot.children
                    .filter { it.hasChild(userId) }
                    .mapNotNull { it.key }

                if (raffleIds.isEmpty()) {
                    _raffles.value = emptyList()
                    return
                }

                journalRef.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(journalSnap: DataSnapshot) {
                        for (raffleId in raffleIds) {
                            val data = journalSnap.child(raffleId)
                            if (data.exists()) {
                                val ts = data.child("timestamp").getValue(Long::class.java)
                                val entries = data.child("entryCount").getValue(Long::class.java)?.toInt()
                                val paid = data.child("totalPaid").getValue(Long::class.java)?.toInt()
                                matched.add(UserRaffleSummary(raffleId, ts, entries, paid))
                            }
                        }
                        _raffles.value = matched.sortedByDescending { it.timestamp ?: 0L }
                    }

                    override fun onCancelled(error: DatabaseError) {}
                })
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }
}

