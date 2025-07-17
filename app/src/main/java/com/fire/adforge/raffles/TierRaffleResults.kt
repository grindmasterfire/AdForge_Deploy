package com.fire.adforge.raffles

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.Timestamp

object TierRaffleResults {
    private val db = FirebaseFirestore.getInstance()

    fun recordWinners(raffleId: String, topWinners: List<String>, consolationWinners: List<String>) {
        val result = hashMapOf(
            "raffleId" to raffleId,
            "topWinners" to topWinners,
            "consolationWinners" to consolationWinners,
            "timestamp" to Timestamp.now()
        )

        db.collection("raffle_results_tiered")
            .add(result)
    }
}
