package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.text.SimpleDateFormat
import java.util.*

class RaffleSanityTestViewModel : ViewModel() {
    private val _log = MutableStateFlow("Awaiting raffle test run...")
    val log: StateFlow<String> get() = _log

    private val db = FirebaseFirestore.getInstance()

    fun runRaffleTest() {
        val now = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())

        val testPayload = mapOf(
            "type" to "21_day",
            "prize_pool" to 10000,
            "jackpot" to 10000,
            "AMOE_triggered" to true,
            "ticket_limit" to 10,
            "timestamp" to now
        )

        db.collection("qa")
            .document("raffleTests")
            .collection("sessions")
            .document(now)
            .set(testPayload)
            .addOnSuccessListener {
                _log.value = "? Raffle sanity test logged to Firebase"
            }
            .addOnFailureListener {
                _log.value = "? Failed to write raffle test log"
            }
    }
}
