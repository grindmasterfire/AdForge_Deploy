package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class LeaderboardUser(
    val username: String = "",
    val avatarUrl: String = "",
    val totalCoins: Int = 0,
    val crewName: String = "",
    val badges: List<String> = emptyList()
)

class GlobalLeaderboardViewModel : ViewModel() {
    private val _leaderboard = MutableStateFlow<List<LeaderboardUser>>(emptyList())
    val leaderboard: StateFlow<List<LeaderboardUser>> = _leaderboard

    private val db = FirebaseFirestore.getInstance()

    init {
        fetchGlobalLeaderboard()
    }

    private fun fetchGlobalLeaderboard() {
        viewModelScope.launch {
            db.collection("users")
                .orderBy("totalCoins", com.google.firebase.firestore.Query.Direction.DESCENDING)
                .limit(50)
                .get()
                .addOnSuccessListener { users ->
                    val userList = mutableListOf<LeaderboardUser>()
                    for (doc in users) {
                        val id = doc.id
                        val username = doc.getString("username") ?: "unknown"
                        val avatarUrl = doc.getString("avatarUrl") ?: ""
                        val totalCoins = (doc.getLong("totalCoins") ?: 0).toInt()
                        val crewName = doc.getString("crew") ?: ""

                        db.collection("users").document(id).collection("badges")
                            .get()
                            .addOnSuccessListener { badgeDocs ->
                                val badges = badgeDocs.mapNotNull { it.getString("name") }
                                val entry = LeaderboardUser(username, avatarUrl, totalCoins, crewName, badges)
                                userList.add(entry)
                                _leaderboard.value = userList.sortedByDescending { it.totalCoins }
                            }
                    }
                }
        }
    }
}
