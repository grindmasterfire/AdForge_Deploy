package com.fire.adforge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.fire.adforge.viewmodel.CoinStateViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun PersonalWallScreen() {
    val coinViewModel: CoinStateViewModel = viewModel()
    val coinBalance = coinViewModel.coins.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("🧱 Personal Wall", style = MaterialTheme.typography.headlineLarge)

        Image(
            painter = painterResource(id = android.R.drawable.sym_def_app_icon),
            contentDescription = "User Avatar",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
        )

        Text("Username: 🔒 Anonymous", style = MaterialTheme.typography.bodyLarge)
        Text("Crew: 🚫 None", style = MaterialTheme.typography.bodyLarge)
        Text("Balance:  coins", style = MaterialTheme.typography.titleLarge)

        Button(onClick = { /* TODO: Edit Avatar or Crew */ }) {
            Text("Customize Wall")
        }
    }
}
