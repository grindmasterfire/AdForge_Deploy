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
import com.google.firebase.firestore.FieldValue

class ClanViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()

    fun joinClan(userId: String, clanId: String, onResult: (Boolean) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                db.collection("users").document(userId)
                    .update("clanId", clanId).await()

                val clanRef = db.collection("clans").document(clanId)
                clanRef.update("members", FieldValue.arrayUnion(userId)).await()
                clanRef.update("memberCount", FieldValue.increment(1)).await()

                val snap = clanRef.get().await()
                val members = (snap.getLong("memberCount") ?: 0).toInt()
                if (members == 5) {
                    PersonalWallViewModel().unlockBadge(userId, "clanFormed")
                }
                onResult(true)
                PersonalWallViewModel().unlockBadge(userId, "crewMate")
            } catch (e: Exception) {
                onResult(false)
            }
        }
    }
}

