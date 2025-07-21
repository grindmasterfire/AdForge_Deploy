package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import com.fire.adforge.model.ClanWallPost
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.tasks.await

class ClanWallViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()
    private val _posts = MutableStateFlow<List<ClanWallPost>>(emptyList())
    val posts: StateFlow<List<ClanWallPost>> = _posts

    suspend fun loadClanWall(clanId: String) {
        val snapshot = db.collection("clans").document(clanId).collection("wall")
            .orderBy("timestamp")
            .get().await()
        _posts.value = snapshot.toObjects(ClanWallPost::class.java)
    }

    suspend fun postToWall(clanId: String, post: ClanWallPost) {
        val ref = db.collection("clans").document(clanId).collection("wall").document()
        val newPost = post.copy(postId = ref.id)
        ref.set(newPost).await()
        loadClanWall(clanId)
    }
}
