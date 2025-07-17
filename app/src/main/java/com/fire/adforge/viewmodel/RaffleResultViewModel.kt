import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.google.firebase.database.*

class RaffleResultViewModel : ViewModel() {
    private val _winner = MutableStateFlow<String?>(null)
    val winner: StateFlow<String?> = _winner

    init {
        val raffleId = "default" // Replace with actual ID logic later
        FirebaseDatabase.getInstance().getReference("raffleResults/\")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    _winner.value = snapshot.getValue(String::class.java)
                }

                override fun onCancelled(error: DatabaseError) {}
            })
    }
}
    fun claimPrize(raffleId: String, userId: String) {
        FirebaseDatabase.getInstance().getReference("claims/${raffleId}")
            .setValue(userId)
    }

