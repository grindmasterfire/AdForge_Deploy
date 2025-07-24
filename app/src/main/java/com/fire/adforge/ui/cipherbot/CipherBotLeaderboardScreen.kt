package com.fire.adforge.ui.cipherbot

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.GlobalLeaderboardViewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun CipherBotLeaderboardScreen() {
    val vm: GlobalLeaderboardViewModel = viewModel()
    val leaderboard by vm.leaderboard.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(" CipherBot Global Leaderboard", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(12.dp))
        LazyColumn {
            itemsIndexed(leaderboard) { index, user ->
                Card(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
                        Text(".", style = MaterialTheme.typography.bodyLarge)
                        Spacer(Modifier.width(8.dp))
                        Image(
                            painter = rememberAsyncImagePainter(user.avatarUrl),
                            contentDescription = "Avatar",
                            modifier = Modifier.size(40.dp)
                        )
                        Spacer(Modifier.width(12.dp))
                        Column {
                            Text(user.username, style = MaterialTheme.typography.titleSmall)
                            Text("Crew:  | Coins: ")
                            Text("Badges: ")
                        }
                    }
                }
            }
        }
    }
}
