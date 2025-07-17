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

class CrewResultsViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()

    private val _winner = MutableStateFlow("Loading...")
    val winner: StateFlow<String> = _winner

    private val _runnerUps = MutableStateFlow<List<String>>(emptyList())
    val runnerUps: StateFlow<List<String>> = _runnerUps

    private val _topPlayers = MutableStateFlow<List<String>>(emptyList())
    val topPlayers: StateFlow<List<String>> = _topPlayers

    fun loadResults(crewTag: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val raffles = db.collection("crews")
                .document(crewTag)
                .collection("raffles")
                .orderBy("startedAt")
                .limitToLast(1)
                .get()
                .await()

            val raffleDoc = raffles.documents.firstOrNull()
            if (raffleDoc != null) {
                val raffleId = raffleDoc.id
                val claimsSnap = db.collection("crews")
                    .document(crewTag)
                    .collection("raffles")
                    .document(raffleId)
                    .collection("claims")
                    .get()
                    .await()

                val claimCounts = claimsSnap.documents
                    .mapNotNull { it.getString("userId") }
                    .groupingBy { it }
                    .eachCount()
                    .toList()
                    .sortedByDescending { it.second }

                val players = claimCounts.map { it.first }
                _topPlayers.value = players.take(5)

                // For now, treat crewTag as winner (real logic pending crew aggregation)
                _winner.value = crewTag
                _runnerUps.value = listOf("Pending Crew 2", "Pending Crew 3")
            }
        }
    }
}

