package com.fire.adforge.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.SponsorFeedViewModel
import com.fire.adforge.viewmodel.SponsorPartner
import kotlinx.coroutines.launch

@Composable
fun SponsorBoardScreen() {
    val context = LocalContext.current
    val viewModel: SponsorFeedViewModel = viewModel()
    val scope = rememberCoroutineScope()
    var sponsors by remember { mutableStateOf<List<SponsorPartner>>(emptyList()) }

    LaunchedEffect(true) {
        sponsors = viewModel.loadSponsors(context)
    }

    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        items(sponsors.size) { index ->
            val sponsor = sponsors[index]
            Card(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = sponsor.name, style = MaterialTheme.typography.titleMedium)
                    Text(text = "Type: ")
                    Text(text = "Status: ")
                }
            }
        }
    }
}
