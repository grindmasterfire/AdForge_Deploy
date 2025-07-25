package com.fire.adforge.engine

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

object RaffleAdminReseedEngine {
    suspend fun clearRaffleEntries(path: String, raffleId: String): Boolean {
        val db = FirebaseFirestore.getInstance()
        val entriesRef = db.collection(path).document(raffleId).collection("entries")

        return try {
            val entries = entriesRef.get().await()
            val batch = db.batch()
            for (doc in entries) {
                batch.delete(doc.reference)
            }
            batch.commit().await()
            true
        } catch (e: Exception) {
            false
        }
    }
}
