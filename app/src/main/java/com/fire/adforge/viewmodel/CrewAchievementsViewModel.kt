import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class CrewAchievement(
    val userId: String = "",
    val coinsEarned: Long = 0,
    val offersCompleted: Int = 0,
    val raffleTicketsContributed: Int = 0
)

class CrewAchievementsViewModel(private val crewId: String) : ViewModel() {

    private val db = FirebaseFirestore.getInstance()
    private val _achievements = MutableStateFlow<Map<String, CrewAchievement>>(emptyMap())
    val achievements: StateFlow<Map<String, CrewAchievement>> = _achievements

    init {
        fetchAchievements()
    }

    private fun fetchAchievements() {
        viewModelScope.launch {
            db.collection("crews")
                .document(crewId)
                .collection("achievements")
                .get()
                .addOnSuccessListener { snapshot ->
                    val results = snapshot.documents.mapNotNull { doc ->
                        doc.toObject(CrewAchievement::class.java)?.copy(userId = doc.id)
                    }.associateBy { it.userId }
                    _achievements.value = results
                }
        }
    }
}

