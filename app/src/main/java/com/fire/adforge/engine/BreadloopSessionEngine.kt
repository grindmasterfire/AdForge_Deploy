package com.fire.adforge.engine

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

object BreadloopSessionEngine {

    suspend fun triggerDrawIfReady(raffleId: String): Boolean {
        val db = FirebaseFirestore.getInstance()
        val entriesRef = db.collection("raffles").document(raffleId).collection("entries")
        val count = entriesRef.get().await().size()

        return if (count >= 5) { // arbitrary minimum for testing
            // Call draw engine logic (placeholder for now)
            Log.d("Breadloop", "Triggering draw for raffle \")
            true
        } else {
            Log.d("Breadloop", "Not enough entries yet for draw: \")
            false
        }
    }
}
