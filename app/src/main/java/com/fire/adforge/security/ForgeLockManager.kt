import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.security

import com.google.firebase.database.*

class ForgeLockManager {

    private val db = FirebaseDatabase.getInstance()

    fun isLocked(raffleId: String, callback: (Boolean) -> Unit) {
        val lockRef = db.getReference("forgeLock/\")
        lockRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                callback(snapshot.getValue(Boolean::class.java) == true)
            }
            override fun onCancelled(error: DatabaseError) {
                callback(false)
            }
        })
    }

    fun lockRaffle(raffleId: String, callback: (Boolean) -> Unit) {
        db.getReference("forgeLock/\").setValue(true)
            .addOnSuccessListener { callback(true) }
            .addOnFailureListener { callback(false) }
    }
}

