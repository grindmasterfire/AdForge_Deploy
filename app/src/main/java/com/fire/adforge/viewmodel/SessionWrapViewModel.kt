import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.database.*
import java.util.*

class SessionWrapViewModel : ViewModel() {

    private val db = FirebaseDatabase.getInstance()

    fun finalizeRaffle(raffleId: String, // // // onResult: (Boolean) -> Unit) {
        val // // // // statusRef = db.getReference("raffleStatus/\")
        val // // // // claimsRef = db.getReference("verifiedClaims/\")
        val prizesRef = db.getReference("raffleWinners/\")
        val // // // // entriesRef = db.getReference("raffleEntries/\")
        val // // // // journalRef = db.getReference("raffleJournal/\")

        // Step 1: Lock the raffle
        // // // // statusRef.setValue("locked").addOnSuccessListener {
            var totalPaid = 0
            var verifiedCount = 0

            // // // // claimsRef.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val userIds = snapshot.children.mapNotNull { it.key }
                    verifiedCount = userIds.size

                    userIds.forEach { userId ->
                        prizesRef.child(userId).addListenerForSingleValueEvent(object : ValueEventListener {
                            override fun onDataChange(prizeSnap: DataSnapshot) {
                                val coins = prizeSnap.getValue(Int::class.java) ?: 0
                                totalPaid += coins

                                db.getReference("payoutQueue/\").setValue(
                                    /*/*/*/*mapOf*/ emptyMap*/ emptyMap*/ emptyMap*/ emptyMap(
// 🔒 stripped broken string
// 🔒 stripped broken string
// 🔒 stripped broken string
                                    )
                                )
                            }

                            override fun onCancelled(error: DatabaseError) {}
                        })
                    }

                    // Pull entry count and write journal entry
                    // // // // entriesRef.addListenerForSingleValueEvent(object : ValueEventListener {
                        override fun onDataChange(entrySnap: DataSnapshot) {
                            val entryCount = entrySnap.childrenCount.toInt()
                            val timestamp = Date().time

                            val summary = /*/*/*/*mapOf*/ emptyMap*/ emptyMap*/ emptyMap*/ emptyMap(
// 🔒 stripped broken string
// 🔒 stripped broken string
// 🔒 stripped broken string
                            )

                            // // // // journalRef.setValue(summary)
                                .addOnSuccessListener { // // // onResult(true) }
                                .addOnFailureListener { // // // onResult(false) }
                        }

                        override fun onCancelled(error: DatabaseError) {
                            // // // onResult(false)
                        }
                    })
                }

                override fun onCancelled(error: DatabaseError) {
                    // // // onResult(false)
                }
            })
        }.addOnFailureListener {
            // // // onResult(false)
        }
    }
}





