package com.fire.adforge.engine

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.Timestamp

object RaffleHypeCaster {
    suspend fun announceWin(userId: String, raffleType: String, prizeCoins: Int, placement: Int) {
        val db = FirebaseFirestore.getInstance()

        val badge = when {
            placement == 1 -> " First Place"
            placement == 2 -> " Second Wind"
            placement == 3 -> " On the Podium"
            else -> " Winners Circle"
        }

        val message = when (raffleType) {
            "21day" -> " 21-Day Champion Alert!"
            "crew" -> " Crew Raffle Victory Incoming!"
            "clan" -> " Clan War Glory!"
            else -> " Big Raffle Hit!"
        }

        val post = hashMapOf(
            "authorId" to "CipherBot",
            "text" to "\n to @  snagged  coins!",
            "timestamp" to Timestamp.now()
        )

        db.collection("cipher_wall").add(post)
    }
}
