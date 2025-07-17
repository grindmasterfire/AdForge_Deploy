import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.database.FirebaseDatabase
import kotlin.random.Random

class TieredRaffleViewModel : ViewModel() {
    private val db = FirebaseDatabase.getInstance()

    fun submitEntry(raffleId: String, userId: String) {
        val ref = db.getReference("raffles/21day/\/entries")
        ref.push().setValue(userId)
    }

    fun finalizeJackpot(raffleId: String) {
        val ref = db.getReference("raffles/21day/\/entries")
        ref.get().addOnSuccessListener { snapshot ->
            val users = snapshot.children.mapNotNull { it.getValue(String::class.java) }
            if (users.isNotEmpty()) {
                val winner = users.random()
                db.getReference("raffles/21day/\/results").setValue(mapOf("winner" to winner))
            }
        }
    }

    fun finalizeTiered(raffleId: String) {
        val ref = db.getReference("raffles/21day/\/entries")
        ref.get().addOnSuccessListener { snapshot ->
            val allUsers = snapshot.children.mapNotNull { it.getValue(String::class.java) }.shuffled()
            val top3 = allUsers.take(3)
            val remaining = allUsers.drop(3)
            val consolation = remaining.shuffled().take((remaining.size * 0.4).toInt())

            val result = mapOf(
                "first" to top3.getOrNull(0),
                "second" to top3.getOrNull(1),
                "third" to top3.getOrNull(2),
                "consolation" to consolation
            )
            db.getReference("raffles/21day/\/results").setValue(result)
        }
    }
}

