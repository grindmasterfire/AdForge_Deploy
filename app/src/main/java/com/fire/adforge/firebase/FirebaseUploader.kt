import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.firebase

import android.util.Log
import com.fire.adforge.model.AuditLogEntry
import com.google.firebase.database.FirebaseDatabase

object FirebaseUploader {
    fun syncAuditLogs() {
        val toUpload = FirebaseSyncQueue.flushQueue()
        val db = FirebaseDatabase.getInstance().getReference("auditLogs")

        for (log in toUpload) {
            val node = db.child(log.raffleId).push()
            node.setValue(log)
                .addOnSuccessListener {
                    Log.d("FirebaseUploader", "Uploaded log: \ @ \")
                }
                .addOnFailureListener {
                    Log.e("FirebaseUploader", "Upload failed: \", it)
                }
        }

        if (toUpload.isEmpty()) {
            Log.i("FirebaseUploader", "No audit logs to sync.")
        }
    }
}

