package com.fire.adforge.raffles

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import kotlin.random.Random

object ClanDrawEngine {
    suspend fun drawWinner(clanId: String, raffleId: String): String? {
        val db = FirebaseFirestore.getInstance()
        val entries = db.collection("clan_raffles")
            .document(clanId)
            .collection("raffles")
            .document(raffleId)
            .collection("entries")
            .get()
            .await()

        if (entries.isEmpty) return null
        val chosen = entries.documents[Random.nextInt(entries.size())]
        return chosen.getString("userId")
    }
}
