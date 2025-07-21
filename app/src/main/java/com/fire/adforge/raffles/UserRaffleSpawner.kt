package com.fire.adforge.raffles

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import java.util.UUID

object UserRaffleSpawner {
    suspend fun createRaffle(
        creatorId: String,
        raffleType: String,
        isPrivate: Boolean,
        cap: Int?,
        durationMs: Long
    ): String? {
        val db = FirebaseFirestore.getInstance()
        val raffleId = UUID.randomUUID().toString()
        val entry = mapOf(
            "creator" to creatorId,
            "raffleType" to raffleType,
            "isPrivate" to isPrivate,
            "ticketCap" to cap,
            "startTime" to System.currentTimeMillis(),
            "endTime" to System.currentTimeMillis() + durationMs
        )
        val ref = db.collection("raffles").document(raffleType).collection("active").document(raffleId)
        return try {
            ref.set(entry).await()
            raffleId
        } catch (e: Exception) {
            null
        }
    }
}
