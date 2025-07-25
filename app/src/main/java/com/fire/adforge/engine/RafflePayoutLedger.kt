package com.fire.adforge.engine

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import kotlin.math.floor

object RafflePayoutLedger {
    suspend fun payoutVariantC(raffleId: String) {
        val db = FirebaseFirestore.getInstance()
        val entriesRef = db.collection("raffles").document(raffleId).collection("entries")
        val snapshot = entriesRef.get().await()
        val entries = snapshot.documents.shuffled()
        val totalTickets = entries.size
        if (totalTickets == 0) return

        val winnersCount = floor(0.60 * totalTickets).toInt()
        val prizePot = (0.75 * totalTickets).toInt()
        val scale = 1.0 + (totalTickets / 10000.0)
        val scaledSum = winnersCount * scale
        val baseValue = prizePot / scaledSum
        val payoutPerWinner = baseValue * scale

        val winners = entries.take(winnersCount)
        val batch = db.batch()
        for (winner in winners) {
            val userId = winner.getString("userId") ?: continue
            val userRef = db.collection("users").document(userId)
            batch.update(userRef, "walletCoins", com.google.firebase.firestore.FieldValue.increment(payoutPerWinner))
        }

        batch.commit().await()
    }
}
