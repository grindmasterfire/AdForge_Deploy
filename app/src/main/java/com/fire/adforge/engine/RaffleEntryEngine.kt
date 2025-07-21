package com.fire.adforge.engine

import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

object RaffleEntryEngine {

    suspend fun recordAmoeEntry(userId: String, raffleId: String) {
        val db = FirebaseFirestore.getInstance()
        val entry = hashMapOf(
            "userId" to userId,
            "timestamp" to Timestamp.now(),
            "entryType" to "AMOE"
        )
        db.collection("raffles")
            .document(raffleId)
            .collection("entries")
            .add(entry)
            .await()
    }

    suspend fun purchaseBonusTickets(
        userId: String,
        raffleId: String,
        count: Int,
        source: String,
        currentSessionCoins: Int,
        walletCoins: Int
    ): Boolean {
        val db = FirebaseFirestore.getInstance()
        val coinsNeeded = count
        val newSession = if (source == "session") currentSessionCoins - coinsNeeded else currentSessionCoins
        val newWallet = if (source == "wallet") walletCoins - coinsNeeded else walletCoins

        if (coinsNeeded > (if (source == "session") currentSessionCoins else walletCoins)) {
            return false
        }

        val batch = db.batch()
        val raffleRef = db.collection("raffles").document(raffleId)

        for (i in 1..count) {
            val ticket = hashMapOf(
                "userId" to userId,
                "timestamp" to Timestamp.now(),
                "entryType" to "BONUS"
            )
            val newDoc = raffleRef.collection("entries").document()
            batch.set(newDoc, ticket)
        }

        val userRef = db.collection("users").document(userId)
        val coinField = if (source == "session") "sessionCoins" else "walletCoins"
        batch.update(userRef, coinField, if (source == "session") newSession else newWallet)

        batch.commit().await()
        return true
    }
}
