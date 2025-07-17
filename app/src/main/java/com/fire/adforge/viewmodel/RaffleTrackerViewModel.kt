import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class RaffleTrackerViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()
    private val _raffleTitle = MutableStateFlow("Loading...")
    val raffleTitle: StateFlow<String> = _raffleTitle

    private val _countdown = MutableStateFlow("...")
    val countdown: StateFlow<String> = _countdown

    private var raffleId: String = ""

    fun loadRaffle(crewTag: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val raffleRef = db.collection("crews")
                .document(crewTag)
                .collection("raffles")
                .orderBy("startedAt")
                .limitToLast(1)
                .get()
                .await()

            val doc = raffleRef.documents.firstOrNull()
            if (doc != null) {
                raffleId = doc.id
                _raffleTitle.value = doc.getString("title") ?: "Untitled"
                val startedAt = doc.getLong("startedAt") ?: 0L
                val remaining = 21 * 60 * 60 * 1000 - (System.currentTimeMillis() - startedAt)
                val hours = (remaining / 3600000).coerceAtLeast(0)
                val mins = ((remaining % 3600000) / 60000).coerceAtLeast(0)
                _countdown.value = "h m left"
            }
        }
    }

    fun submitClaim(userId: String) {
        if (raffleId.isBlank()) return

        CoroutineScope(Dispatchers.IO).launch {
            val claim = hashMapOf(
                "userId" to userId,
                "timestamp" to System.currentTimeMillis()
            )
            db.collection("crews")
                .document("Alpha Crew")
                .collection("raffles")
                .document(raffleId)
                .collection("claims")
                .add(claim)
        }
    }
}

