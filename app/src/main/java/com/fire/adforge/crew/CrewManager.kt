import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.crew

import com.google.firebase.firestore.FirebaseFirestore

data class CrewMember(
    val uid: String = "",
    val name: String = "",
    val rank: Int = 1,
    val totalEarned: Int = 0,
    val crewReferrer: String? = null
)

class CrewManager {
    private val db = FirebaseFirestore.getInstance()
    private val crewCollection = db.collection("crews")

    fun registerMember(uid: String, name: String, referrer: String?) {
        val member = CrewMember(uid = uid, name = name, crewReferrer = referrer)
        crewCollection.document(uid).set(member)
    }

    fun updateEarnings(uid: String, newCoins: Int) {
        crewCollection.document(uid).get().addOnSuccessListener { snapshot ->
            val current = snapshot.toObject(CrewMember::class.java)
            if (current != null) {
                val updated = current.copy(totalEarned = current.totalEarned + newCoins)
                crewCollection.document(uid).set(updated)
            }
        }
    }

    fun calculateReferralBonus(level: Int, amount: Int): Int {
        return when (level) {
            1 -> (amount * 0.10).toInt()
            2 -> (amount * 0.05).toInt()
            3 -> (amount * 0.03).toInt()
            4 -> (amount * 0.01).toInt()
            else -> 0
        }
    }
}

