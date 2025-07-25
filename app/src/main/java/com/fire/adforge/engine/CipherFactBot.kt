package com.fire.adforge.engine

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.Timestamp

object CipherFactBot {
    private val facts = listOf(
        " You can earn a raffle ticket every 27 minutes during autoplay. Stay alert.",
        " Referrals give you 10/5/3/1% of their grind. Respect the tree.",
        " Coins can't be bought  only earned. AdForge is built different.",
        " Crew raffles happen monthly. Top grinders get the glory.",
        " Your DNA Snapshot shows your badges, milestones, and legacy rank.",
        " Milestone boosters give you a 510% speed-up  earn them, dont fake them.",
        " AMOE entries are logged and sweepstakes compliant. We play by the book.",
        " 90% of revenue is paid to users. 10% funds Fires coffee."
    )

    suspend fun postRandomFact() {
        val db = FirebaseFirestore.getInstance()
        val fact = facts.random()

        val post = hashMapOf(
            "authorId" to "CipherBot",
            "text" to fact,
            "timestamp" to Timestamp.now()
        )

        db.collection("cipher_wall").add(post)
    }
}
