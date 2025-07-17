import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.database.*
import org.json.JSONObject

class ReceiptQRViewModel : ViewModel() {

    private val db = FirebaseDatabase.getInstance()
    private val userId = "testUser" // Replace with actual user ID logic

    fun generateQRPayload(onReady: (String?) -> Unit) {
        val payoutRef = db.getReference("payoutQueue/\")

        payoutRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val raffleId = snapshot.child("raffleId").getValue(String::class.java) ?: return
                val amount = snapshot.child("amount").getValue(Long::class.java)?.toInt() ?: return
                val status = snapshot.child("status").getValue(String::class.java) ?: "pending"

                val verifiedRef = db.getReference("verifiedClaims/\/\")
                verifiedRef.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(verifiedSnap: DataSnapshot) {
                        val timestamp = verifiedSnap.getValue(Long::class.java)
                        val json = JSONObject().apply {
                            put("raffleId", raffleId)
                            put("userId", userId)
                            put("amount", amount)
                            put("status", status)
                            if (timestamp != null) put("timestamp", timestamp)
                        }
                        onReady(json.toString())
                    }

                    override fun onCancelled(error: DatabaseError) {
                        onReady(null)
                    }
                })
            }

            override fun onCancelled(error: DatabaseError) {
                onReady(null)
            }
        })
    }
}

