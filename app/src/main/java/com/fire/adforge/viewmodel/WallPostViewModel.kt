package com.fire.adforge.viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fire.adforge.engine.WallImageUploader
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.Timestamp
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WallPostViewModel : ViewModel() {
    val message = MutableStateFlow("")
    val imageUri = MutableStateFlow<Uri?>(null)
    val status = MutableStateFlow("")

    private val db = FirebaseFirestore.getInstance()
    private val userId = "demoUser"

    fun submitWallPost(collectionPath: String) {
        viewModelScope.launch {
            val text = message.value
            val uri = imageUri.value
            var imageUrl: String? = null

            if (uri != null) {
                imageUrl = WallImageUploader.uploadWallImage(uri, userId)
            }

            val post = hashMapOf(
                "authorId" to userId,
                "text" to text,
                "imageUrl" to imageUrl,
                "timestamp" to Timestamp.now()
            )

            db.collection(collectionPath).add(post)
                .addOnSuccessListener { status.value = "Posted!" }
                .addOnFailureListener { status.value = "Failed to post." }
        }
    }
}
