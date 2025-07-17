import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class BoostLog(
    val coinsSpent: Int = 0,
    val source: String = "",
    val timestamp: Long = 0L
)

class MilestoneLogViewModel : ViewModel() {
    private val _boostLog = MutableStateFlow<BoostLog?>(null)
    val boostLog: StateFlow<BoostLog?> = _boostLog

    private val db = FirebaseFirestore.getInstance()
    private val uid = FirebaseAuth.getInstance().currentUser?.uid ?: "anon"

    fun fetchLog(offerId: String) {
        viewModelScope.launch {
            db.collection("milestones")
                .document(offerId)
                .collection("logs")
                .document(uid)
                .get()
                .addOnSuccessListener {
                    val log = BoostLog(
                        coinsSpent = it.getLong("coinsSpent")?.toInt() ?: 0,
                        source = it.getString("source") ?: "",
                        timestamp = it.getTimestamp("timestamp")?.toDate()?.time ?: 0L
                    )
                    _boostLog.value = log
                }
        }
    }
}

