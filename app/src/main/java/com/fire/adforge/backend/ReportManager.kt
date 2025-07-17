package com.fire.adforge.backend

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import java.util.*

data class ModReport(
    val reporterId: String = "",
    val targetUserId: String = "",
    val reason: String = "",
    val timestamp: Long = System.currentTimeMillis()
)

object ReportManager {
    private val db = FirebaseFirestore.getInstance()

    suspend fun submitReport(report: ModReport) {
        db.collection("mod_reports").add(report).await()
    }
}
