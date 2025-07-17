package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.text.SimpleDateFormat
import java.util.*

class LivenessTestViewModel : ViewModel() {
    private val _result = MutableStateFlow("? Awaiting liveness input...")
    val result: StateFlow<String> get() = _result

    private val db = FirebaseFirestore.getInstance()

    fun simulateResponse(userClicked: Boolean) {
        val timeId = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val payload = mapOf(
            "timestamp" to timeId,
            "responded" to userClicked,
            "device" to android.os.Build.MODEL,
            "sdk" to android.os.Build.VERSION.SDK_INT
        )

        db.collection("qa")
            .document("livenessTests")
            .collection("sessions")
            .document(timeId)
            .set(payload)
            .addOnSuccessListener {
                _result.value = if (userClicked) "? User passed liveness" else "? No response — fraud flag simulated"
            }
            .addOnFailureListener {
                _result.value = "?? Firebase logging failed"
            }
    }
}
