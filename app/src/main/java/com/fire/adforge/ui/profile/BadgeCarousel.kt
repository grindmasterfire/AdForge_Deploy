package com.fire.adforge.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.BadgeCarouselViewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun BadgeCarousel(userId: String) {
    val vm: BadgeCarouselViewModel = viewModel()
    val badges by vm.badges.collectAsState()

    LaunchedEffect(userId) {
        vm.loadBadges(userId)
    }

    Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Text(" Badges", style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(8.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(badges) { badge ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = rememberAsyncImagePainter(badge.iconUrl),
                        contentDescription = badge.name,
                        modifier = Modifier.size(48.dp)
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(badge.name, style = MaterialTheme.typography.bodySmall)
                }
            }
        }
    }
}
