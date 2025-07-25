package com.fire.adforge.ui.wall

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.Timestamp

data class WallPost(
    val authorId: String = "",
    val text: String = "",
    val imageUrl: String? = null,
    val timestamp: Timestamp = Timestamp.now()
)

@Composable
fun WallFeedScreen(collectionPath: String) {
    var posts by remember { mutableStateOf(listOf<WallPost>()) }

    LaunchedEffect(Unit) {
        FirebaseFirestore.getInstance().collection(collectionPath)
            .orderBy("timestamp", com.google.firebase.firestore.Query.Direction.DESCENDING)
            .addSnapshotListener { snapshot, _ ->
                posts = snapshot?.map { doc ->
                    WallPost(
                        authorId = doc.getString("authorId") ?: "",
                        text = doc.getString("text") ?: "",
                        imageUrl = doc.getString("imageUrl"),
                        timestamp = doc.getTimestamp("timestamp") ?: Timestamp.now()
                    )
                } ?: listOf()
            }
    }

    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        items(posts) { post ->
            Card(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(post.text)
                    post.imageUrl?.let {
                        Spacer(Modifier.height(8.dp))
                        Image(
                            painter = rememberAsyncImagePainter(it),
                            contentDescription = "Wall Image",
                            modifier = Modifier.fillMaxWidth().height(200.dp)
                        )
                    }
                }
            }
        }
    }
}
