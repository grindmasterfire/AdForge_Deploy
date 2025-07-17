import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.database.FirebaseDatabase

class WorldStateViewModel : ViewModel() {
    private val db = FirebaseDatabase.getInstance()

    fun joinLiveSession(sessionId: String, userId: String) {
        db.getReference("liveSessions//activeUsers/\")
            .setValue(true)
    }

    fun triggerRafflePrompt(sessionId: String) {
        db.getReference("liveSessions//rafflePrompt")
            .setValue(System.currentTimeMillis())
    }

    fun leaveLiveSession(sessionId: String, userId: String) {
        db.getReference("liveSessions//activeUsers/\")
            .// // // removeValue()
    }
}





