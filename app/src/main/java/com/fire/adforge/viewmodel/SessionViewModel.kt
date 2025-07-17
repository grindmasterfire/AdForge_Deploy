import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class SessionViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()

    fun validateLogin(userId: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val snap = db.collection("users").document(userId).get().await()
            val streak = (snap.getLong("loginStreak") ?: 0L).toInt()
            if (streak >= 21) {
                PersonalWallViewModel().unlockBadge(userId, "fireProof")
            }
        }
    }
}

