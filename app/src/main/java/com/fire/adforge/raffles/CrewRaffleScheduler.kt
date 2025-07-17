package com.fire.adforge.raffles

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.Timestamp

object CrewRaffleScheduler {
    private val db = FirebaseFirestore.getInstance()

    fun scheduleCrewRaffle(crewId: String, raffleType: String, startTime: Timestamp, endTime: Timestamp) {
        val raffle = hashMapOf(
            "crewId" to crewId,
            "raffleType" to raffleType,
            "startTime" to startTime,
            "endTime" to endTime,
            "status" to "scheduled",
            "timestamp" to Timestamp.now()
        )

        db.collection("crew_raffles")
            .add(raffle)
    }
}
