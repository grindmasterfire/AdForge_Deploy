import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.crew

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

object CrewMultiplierEngine {

    private val db = FirebaseFirestore.getInstance()

    suspend fun applyCrewMultiplier(userId: String, rawEarnings: Int): Int {
        return try {
            val profile = db.collection("user_wall").document(userId).get().await()
            val crewName = profile.getString("crewName") ?: return rawEarnings

            val crewDoc = db.collection("crew_meta").document(crewName).get().await()
            val multiplier = crewDoc.getDouble("multiplier") ?: 1.0

            val boosted = (rawEarnings * multiplier).toInt()
            Log.d("CrewMultiplier", "Applied x\ ? \")
            boosted

        } catch (e: Exception) {
            Log.e("CrewMultiplierEngine", "Failed multiplier calc", e)
            rawEarnings
        }
    }
}

