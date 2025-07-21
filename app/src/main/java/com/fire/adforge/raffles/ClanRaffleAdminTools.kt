package com.fire.adforge.raffles

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

object ClanRaffleAdminTools {
    suspend fun cancelRaffle(clanId: String, raffleId: String): Boolean {
        return try {
            val db = FirebaseFirestore.getInstance()
            val docRef = db.collection(\"clan_raffles\")
                .document(clanId)
                .collection(\"raffles\")
                .document(raffleId)
            docRef.update(\"status\", \"cancelled\").await()
            true
        } catch (e: Exception) {
            false
        }
    }

    suspend fun rerollRaffle(clanId: String, raffleId: String, rewardAmount: Int): Boolean {
        return ClanRaffleMacroEngine.runFullDrawCycle(
            clanId = clanId,
            raffleId = raffleId,
            raffleType = \"REROLL_ADMIN\",
            rewardAmount = rewardAmount
        )
    }
}
