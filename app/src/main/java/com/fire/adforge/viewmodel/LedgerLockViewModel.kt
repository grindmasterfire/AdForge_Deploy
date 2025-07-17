import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.database.*

class LedgerLockViewModel : ViewModel() {

    private val db = FirebaseDatabase.getInstance()

    fun lockRaffle(raffleId: String, onComplete: (Boolean) -> Unit) {
        val resultsRef = db.getReference("raffleResults/\")
        val verifiedRef = db.getReference("verifiedClaims/\")
        val archiveRef = db.getReference("archivedRaffles/\")

        val combinedData = mutableMapOf<String, Any>()

        resultsRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(resultsSnap: DataSnapshot) {
                combinedData["raffleResults"] = resultsSnap.value ?: emptyMap<String, Any>()

                verifiedRef.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(verifiedSnap: DataSnapshot) {
                        combinedData["verifiedClaims"] = verifiedSnap.value ?: emptyMap<String, Any>()

                        archiveRef.setValue(combinedData)
                            .addOnSuccessListener { onComplete(true) }
                            .addOnFailureListener { onComplete(false) }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        onComplete(false)
                    }
                })
            }

            override fun onCancelled(error: DatabaseError) {
                onComplete(false)
            }
        })
    }
}

