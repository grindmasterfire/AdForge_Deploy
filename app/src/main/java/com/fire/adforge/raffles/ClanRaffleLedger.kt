package com.fire.adforge.raffles

import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

object ClanRaffleLedger {
    suspend fun logClanEntry(userId: String, clanId: String, raffleId: String, type: String) {
        val db = FirebaseFirestore.getInstance()
        val entry = mapOf(
            "userId" to userId,
            "timestamp" to Timestamp.now(),
            "entryType" to type
        )
        db.collection("clan_raffles")
            .document(clanId)
            .collection("raffles")
            .document(raffleId)
            .collection("entries")
            .add(entry)
            .await()
    }
}
