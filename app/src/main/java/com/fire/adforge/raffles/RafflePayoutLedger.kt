package com.fire.adforge.raffles

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import java.util.Date

object RafflePayoutLedger {
    suspend fun logPayout(raffleId: String, raffleType: String, totalCoins: Int) {
        val db = FirebaseFirestore.getInstance()
        val ledger = mapOf(
            "raffleId" to raffleId,
            "raffleType" to raffleType,
            "totalPool" to totalCoins,
            "userPayout" to (totalCoins * 0.75).toInt(),
            "retained" to (totalCoins * 0.15).toInt(),
            "fireCut" to (totalCoins * 0.10).toInt(),
            "timestamp" to Date()
        )
        db.collection("raffle_ledger")
            .document(raffleId)
            .set(ledger)
            .await()
    }
}
