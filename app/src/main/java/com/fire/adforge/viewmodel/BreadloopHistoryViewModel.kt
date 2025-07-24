package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class BreadloopSession(
    val timestamp: String = "",
    val livenessTime: Long = 0,
    val earnedAmoe: Boolean = false,
    val bonusTickets: Int = 0
)

class BreadloopHistoryViewModel : ViewModel() {
    private val _sessionHistory = MutableStateFlow<List<BreadloopSession>>(emptyList())
    val sessionHistory: StateFlow<List<BreadloopSession>> = _sessionHistory

    private val db = FirebaseFirestore.getInstance()
    private val userId = "demoUser" // replace with actual UID in prod

    init {
        fetchHistory()
    }

    private fun fetchHistory() {
        viewModelScope.launch {
            db.collection("users").document(userId)
                .collection("breadloop_sessions")
                .get()
                .addOnSuccessListener { result ->
                    val sessions = result.map { doc ->
                        BreadloopSession(
                            timestamp = doc.getTimestamp("timestamp")?.toDate().toString(),
                            livenessTime = doc.getLong("livenessTime") ?: 0,
                            earnedAmoe = doc.getBoolean("earnedAmoe") ?: false,
                            bonusTickets = (doc.getLong("bonusTickets") ?: 0).toInt()
                        )
                    }
                    _sessionHistory.value = sessions.sortedByDescending { it.timestamp }
                }
        }
    }
}
