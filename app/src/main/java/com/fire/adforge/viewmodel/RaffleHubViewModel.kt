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

class RaffleHubViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()
    private val _crewEligible = MutableStateFlow(false)
    private val _clanEligible = MutableStateFlow(false)

    val crewEligible: StateFlow<Boolean> get() = _crewEligible
    val clanEligible: StateFlow<Boolean> get() = _clanEligible

    fun checkCrewAndClanStatus(userId: String) {
        db.collection("users").document(userId).get().addOnSuccessListener { doc ->
            val crewId = doc.getString("crewId")
            val clanId = doc.getString("clanId")

            _crewEligible.value = !crewId.isNullOrEmpty()
            _clanEligible.value = !clanId.isNullOrEmpty()
        }
    }
}

