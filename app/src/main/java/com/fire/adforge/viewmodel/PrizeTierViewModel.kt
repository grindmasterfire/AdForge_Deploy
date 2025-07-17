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

data class TierResult(val tier: String, val amount: Int, val winners: List<String>)

class PrizeTierViewModel : ViewModel() {
    private val _tiers = MutableStateFlow<List<TierResult>>(emptyList())
    val tiers: StateFlow<List<TierResult>> = _tiers

    private val db = FirebaseDatabase.getInstance()
    private val raffleId = "RAFFLE123" // Replace with dynamic logic later

    init {
        val winnersRef = db.getReference("raffleResults/\/tierWinners")
        val amountsRef = db.getReference("raffleResults/\/tierAmounts")

        winnersRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(winnerSnap: DataSnapshot) {
                val tempResults = mutableListOf<TierResult>()

                amountsRef.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(amountSnap: DataSnapshot) {
                        for (tier in winnerSnap.children) {
                            val tierName = tier.key ?: continue
                            val winners = tier.children.mapNotNull { it.getValue(String::class.java) }
                            val amount = amountSnap.child(tierName).getValue(Int::class.java) ?: 0
                            tempResults.add(TierResult(tierName, amount, winners))
                        }
                        _tiers.value = tempResults
                    }

                    override fun onCancelled(error: DatabaseError) {}
                })
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }
}

