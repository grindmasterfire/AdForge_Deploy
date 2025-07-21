package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.fire.adforge.model.CrewWallPost
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.tasks.await

class CrewWallViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()
    private val _posts = MutableStateFlow<List<CrewWallPost>>(emptyList())
    val posts: StateFlow<List<CrewWallPost>> = _posts

    suspend fun loadCrewWall(crewId: String) {
        val snapshot = db.collection("crews").document(crewId).collection("wall")
            .orderBy("timestamp")
            .get().await()
        _posts.value = snapshot.toObjects(CrewWallPost::class.java)
    }

    suspend fun postToWall(crewId: String, post: CrewWallPost) {
        val ref = db.collection("crews").document(crewId).collection("wall").document()
        val newPost = post.copy(postId = ref.id)
        ref.set(newPost).await()
        loadCrewWall(crewId)
    }
}
