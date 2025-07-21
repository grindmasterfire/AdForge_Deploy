package com.fire.adforge.raffles

import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

object ClanRaffleAuditLog {
    suspend fun logWinner(clanId: String, raffleId: String, userId: String, coinsAwarded: Int, raffleType: String) {
        val db = FirebaseFirestore.getInstance()
        val log = hashMapOf(
            "userId" to userId,
            "coins" to coinsAwarded,
            "raffleType" to raffleType,
            "timestamp" to Timestamp.now()
        )
        db.collection("clan_raffles")
            .document(clanId)
            .collection("raffles")
            .document(raffleId)
            .collection("winners")
            .add(log)
            .await()
    }
}
