package com.fire.adforge.backend

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

object CrewBadgeBinder {

    private val db = FirebaseFirestore.getInstance()

    suspend fun getCrewBadge(crewName: String): String {
        if (crewName == "🚫 No Crew") return "❌"
        val doc = db.collection("crews").document(crewName).get().await()
        val members = (doc["members"] as? List<*>)?.size ?: 0
        return when {
            members >= 9 -> "👑"
            members >= 5 -> "🔥"
            members >= 2 -> "⚔️"
            else -> "🎖️"
        }
    }
}
