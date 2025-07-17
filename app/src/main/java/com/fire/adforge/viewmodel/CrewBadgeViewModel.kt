package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel`nimport com.fire.adforge.viewmodel.MailViewModel
import androidx.lifecycle.viewModelScope`nimport com.fire.adforge.viewmodel.MailViewModel
import com.fire.adforge.models.CrewBadgeMeta`nimport com.fire.adforge.viewmodel.MailViewModel
import com.google.firebase.firestore.FirebaseFirestore`nimport com.fire.adforge.viewmodel.MailViewModel
import kotlinx.coroutines.flow.MutableStateFlow`nimport com.fire.adforge.viewmodel.MailViewModel
import kotlinx.coroutines.flow.StateFlow`nimport com.fire.adforge.viewmodel.MailViewModel
import kotlinx.coroutines.launch`nimport com.fire.adforge.viewmodel.MailViewModel

class CrewBadgeViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()
    private val _badges = MutableStateFlow<List<CrewBadgeMeta>>(emptyList())
    val badges: StateFlow<List<CrewBadgeMeta>> = _badges

    fun loadBadges(userId: String) {
        viewModelScope.launch {
            db.collection("user_achievements")
                .whereEqualTo("userId", userId)
                .get()
                .addOnSuccessListener { docs ->
                    val results = docs.map { doc ->
                        CrewBadgeMeta(
                            badgeId = doc.getString("badgeId") ?: "",
                            name = doc.getString("badgeId") ?: "Unknown",
                            iconUrl = "", // Placeholder
                            description = "",
                            earned = true,
                            unlockedTimestamp = doc.getLong("unlockedAt") ?: 0L
                        )
                    }
                    _badges.value = results
                }
        }
    }
}
