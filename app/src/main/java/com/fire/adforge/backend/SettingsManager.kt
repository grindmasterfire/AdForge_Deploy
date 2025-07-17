package com.fire.adforge.backend

import com.fire.adforge.model.UserSettings
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

object SettingsManager {
    private val db = FirebaseFirestore.getInstance()

    suspend fun fetchSettings(userId: String): UserSettings {
        val doc = db.collection("settings").document(userId).get().await()
        return doc.toObject(UserSettings::class.java) ?: UserSettings()
    }

    suspend fun updateSettings(userId: String, settings: UserSettings) {
        db.collection("settings").document(userId).set(settings).await()
    }
}
