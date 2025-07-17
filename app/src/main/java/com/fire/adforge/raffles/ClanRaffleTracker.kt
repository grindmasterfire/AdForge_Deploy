package com.fire.adforge.raffles

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.Timestamp

object ClanRaffleTracker {
    private val db = FirebaseFirestore.getInstance()

    fun trackClanRaffle(clanId: String, participants: List<String>, totalTickets: Int) {
        val data = hashMapOf(
            "clanId" to clanId,
            "participants" to participants,
            "totalTickets" to totalTickets,
            "timestamp" to Timestamp.now()
        )

        db.collection("clan_raffle_logs")
            .add(data)
    }
}
