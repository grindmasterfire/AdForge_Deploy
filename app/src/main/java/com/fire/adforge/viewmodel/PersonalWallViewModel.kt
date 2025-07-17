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

class PersonalWallViewModel : ViewModel() {
    fun unlockBadge(userId: String, badgeId: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val badgeRef = db.collection("users")
                .document(userId)
                .collection("badges")
                .document(badgeId)

            badgeRef.set(mapOf("unlockedAt" to System.currentTimeMillis()))
        }
    }
    private val db = FirebaseFirestore.getInstance()
    private val _unlockedBadges = MutableStateFlow<List<String>>(emptyList())
    val unlockedBadges: StateFlow<List<String>> = _unlockedBadges
    private val _unlockedTimestamps = MutableStateFlow<Map<String, Long>>(emptyMap())
    val unlockedTimestamps: StateFlow<Map<String, Long>> = _unlockedTimestamps

    fun loadUnlocked(userId: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val badgeSnap = db.collection("users")
                .document(userId)
                .collection("badges")
                .get()
                .await()

            _unlockedBadges.value = badgeSnap.documents.mapNotNull { it.id }
        }
    }
}

