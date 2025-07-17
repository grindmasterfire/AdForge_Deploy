import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.profile

import android.net.Uri
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.tasks.await

data class UserWallMeta(
    val userId: String = "",
    val avatarUrl: String = "",
    val grindStatus: String = "",
    val crewName: String? = null,
    val achievements: List<String> = listOf(),
    val badges: List<String> = listOf()
)

object UserWallManager {

    private val auth = FirebaseAuth.getInstance()
    private val firestore = FirebaseFirestore.getInstance()
    private val storage = FirebaseStorage.getInstance().reference

    suspend fun uploadAvatar(imageUri: Uri): String? {
        val uid = auth.currentUser?.uid ?: return null
        val avatarRef = storage.child("avatars/\.jpg")

        return try {
            avatarRef.putFile(imageUri).await()
            val url = avatarRef.downloadUrl.await().toString()
            firestore.collection("user_wall").document(uid).update("avatarUrl", url)
            url
        } catch (e: Exception) {
            Log.e("UserWallManager", "Avatar upload failed", e)
            null
        }
    }

    suspend fun saveWallMeta(meta: UserWallMeta) {
        val uid = auth.currentUser?.uid ?: return
        firestore.collection("user_wall").document(uid).set(meta)
    }

    suspend fun fetchWallMeta(userId: String): UserWallMeta? {
        return try {
            val doc = firestore.collection("user_wall").document(userId).get().await()
            doc.toObject(UserWallMeta::class.java)
        } catch (e: Exception) {
            Log.e("UserWallManager", "Fetch failed", e)
            null
        }
    }
}

