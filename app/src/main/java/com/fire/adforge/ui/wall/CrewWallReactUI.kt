package com.fire.adforge.ui.wall

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.CrewWallReactViewModel

@Composable
fun CrewWallReactUI(postId: String, crewId: String) {
    val vm: CrewWallReactViewModel = viewModel()
    val emoji by vm.emoji.collectAsState()
    val badge by vm.selectedBadge.collectAsState()
    val status by vm.status.collectAsState()

    LaunchedEffect(postId, crewId) {
        vm.postId.value = postId
        vm.crewId.value = crewId
    }

    Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        OutlinedTextField(
            value = emoji,
            onValueChange = { vm.emoji.value = it },
            label = { Text("Emoji") }
        )
        OutlinedTextField(
            value = badge,
            onValueChange = { vm.selectedBadge.value = it },
            label = { Text("Badge Name") }
        )
        Spacer(Modifier.height(8.dp))
        Button(onClick = { vm.react() }) {
            Text("React to Post")
        }
        Text(status)
    }
}
