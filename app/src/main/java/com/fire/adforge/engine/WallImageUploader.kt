package com.fire.adforge.engine

import android.net.Uri
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.tasks.await
import java.util.*

object WallImageUploader {
    suspend fun uploadWallImage(uri: Uri, userId: String): String? {
        val storage = FirebaseStorage.getInstance()
        val path = "wall_images/\/\.jpg"
        val ref = storage.reference.child(path)

        return try {
            ref.putFile(uri).await()
            ref.downloadUrl.await().toString()
        } catch (e: Exception) {
            null
        }
    }
}
