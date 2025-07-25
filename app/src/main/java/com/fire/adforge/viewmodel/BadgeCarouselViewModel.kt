package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class Badge(
    val name: String = "",
    val iconUrl: String = ""
)

class BadgeCarouselViewModel : ViewModel() {
    private val _badges = MutableStateFlow<List<Badge>>(emptyList())
    val badges: StateFlow<List<Badge>> = _badges

    private val db = FirebaseFirestore.getInstance()

    fun loadBadges(userId: String) {
        viewModelScope.launch {
            db.collection("users").document(userId)
                .collection("badges")
                .get()
                .addOnSuccessListener { result ->
                    val list = result.map { doc ->
                        Badge(
                            name = doc.getString("name") ?: "Unknown",
                            iconUrl = doc.getString("iconUrl") ?: ""
                        )
                    }
                    _badges.value = list
                }
        }
    }
}
