package com.fire.adforge.ui.clan

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.ClanWallViewModel
import com.fire.adforge.model.ClanWallPost
import kotlinx.coroutines.launch

@Composable
fun ClanWallScreen(clanId: String) {
    val vm: ClanWallViewModel = viewModel()
    val posts by vm.posts.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    var message by remember { mutableStateOf("") }

    LaunchedEffect(clanId) {
        vm.loadClanWall(clanId)
    }

    Column(modifier = Modifier.fillMaxSize().padding(12.dp)) {
        Text("Clan Wall", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(posts) { post ->
                ClanWallPostCard(post)
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
                    val post = ClanWallPost(
                        clanId = clanId,
                        authorId = "currentUserId", // replace with real ID
                        content = message,
                        timestamp = System.currentTimeMillis()
                    )
                    vm.postToWall(clanId, post)
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
fun ClanWallPostCard(post: ClanWallPost) {
    Card(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(post.content)
            if (post.badgeId != null) {
                Text(" Badge: ", style = MaterialTheme.typography.labelSmall)
            }
        }
    }
}
