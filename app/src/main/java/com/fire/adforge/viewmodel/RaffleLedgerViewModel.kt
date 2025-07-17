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

data class LedgerEntry(val raffleId: String, val userId: String, val timestamp: Long, val coins: Int?)

class RaffleLedgerViewModel : ViewModel() {
    private val _ledger = MutableStateFlow<List<LedgerEntry>>(emptyList())
    val ledger: StateFlow<List<LedgerEntry>> = _ledger

    private val db = FirebaseDatabase.getInstance()

    init {
        val ledgerRef = db.getReference("verifiedClaims")
        ledgerRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<LedgerEntry>()
                for (raffleSnap in snapshot.children) {
                    val raffleId = raffleSnap.key ?: continue
                    for (userSnap in raffleSnap.children) {
                        val userId = userSnap.key ?: continue
                        val timestamp = userSnap.getValue(Long::class.java) ?: continue

                        db.getReference("raffleWinners/\/\")
                            .addListenerForSingleValueEvent(object : ValueEventListener {
                                override fun onDataChange(coinSnap: DataSnapshot) {
                                    val coins = coinSnap.getValue(Int::class.java)
                                    list.add(LedgerEntry(raffleId, userId, timestamp, coins))
                                    _ledger.value = list.toList()
                                }

                                override fun onCancelled(error: DatabaseError) {}
                            })
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }
}

