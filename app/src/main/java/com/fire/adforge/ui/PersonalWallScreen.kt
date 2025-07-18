package com.fire.adforge.ui

import androidx.compose.foundation.Image`nimport androidx.navigation.NavController
import androidx.compose.foundation.layout.*`nimport androidx.navigation.NavController
import androidx.compose.foundation.shape.CircleShape`nimport androidx.navigation.NavController
import androidx.compose.material3.*`nimport androidx.navigation.NavController
import androidx.compose.runtime.*`nimport androidx.navigation.NavController
import androidx.compose.ui.Alignment`nimport androidx.navigation.NavController
import androidx.compose.ui.Modifier`nimport androidx.navigation.NavController
import androidx.compose.ui.draw.clip`nimport androidx.navigation.NavController
import androidx.compose.ui.res.painterResource`nimport androidx.navigation.NavController
import androidx.compose.ui.unit.dp`nimport androidx.navigation.NavController
import com.fire.adforge.viewmodel.CoinStateViewModel`nimport androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel`nimport androidx.navigation.NavController

@Composable
fun PersonalWallScreen(navController: NavController) {
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
            Text("📬 Open Mailbox")
        }
    }
}
