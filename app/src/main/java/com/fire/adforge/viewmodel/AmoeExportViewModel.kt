package com.fire.adforge.viewmodel

import android.content.Context
import android.os.Environment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileWriter

class AmoeExportViewModel : ViewModel() {
    val db = FirebaseFirestore.getInstance()

    fun exportAmoeCSV(context: Context, onDone: (Boolean, String) -> Unit) {
        viewModelScope.launch {
            try {
                db.collection("amoe_log")
                    .get()
                    .addOnSuccessListener { snapshot ->
                        val outputDir = context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
                        val file = File(outputDir, "amoe_export.csv")
                        val writer = FileWriter(file)

                        writer.appendLine("UserID,RaffleID,LivenessMs,Timestamp")
                        for (doc in snapshot) {
                            val userId = doc.getString("userId") ?: ""
                            val raffleId = doc.getString("raffleId") ?: ""
                            val ms = doc.getLong("livenessTimeMs") ?: 0
                            val timestamp = doc.getTimestamp("timestamp")?.toDate().toString()

                            writer.appendLine(",,,")
                        }

                        writer.flush()
                        writer.close()
                        onDone(true, "Exported to: ")
                    }
            } catch (e: Exception) {
                onDone(false, "Export failed: ")
            }
        }
    }
}
