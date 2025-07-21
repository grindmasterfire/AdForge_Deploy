package com.fire.adforge.ui.crew

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.CrewWallViewModel
import com.fire.adforge.model.CrewWallPost
import kotlinx.coroutines.launch

@Composable
fun CrewWallScreen(crewId: String) {
    val vm: CrewWallViewModel = viewModel()
    val posts by vm.posts.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    var message by remember { mutableStateOf("") }

    LaunchedEffect(crewId) {
        vm.loadCrewWall(crewId)
    }

    Column(modifier = Modifier.fillMaxSize().padding(12.dp)) {
        Text("Crew Wall", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(posts) { post ->
                CrewWallPostCard(post)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = message,
            onValueChange = { message = it },
            label = { Text("Post a message") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                coroutineScope.launch {
                    val post = CrewWallPost(
                        crewId = crewId,
                        authorId = "currentUserId", // replace with real ID
                        content = message,
                        timestamp = System.currentTimeMillis()
                    )
                    vm.postToWall(crewId, post)
                    message = ""
                }
            },
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
        ) {
            Text("Post")
        }
    }
}

@Composable
fun CrewWallPostCard(post: CrewWallPost) {
    Card(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(post.content)
            if (post.badgeId != null) {
                Text(" Badge: ", style = MaterialTheme.typography.labelSmall)
            }
        }
    }
}
