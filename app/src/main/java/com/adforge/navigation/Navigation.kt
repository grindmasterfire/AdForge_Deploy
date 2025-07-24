package com.adforge.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.adforge.viewmodels.MainViewModel
import com.adforge.screens.HomeScreen
import com.adforge.screens.RaffleScreen
import com.adforge.screens.WatchScreen

@Composable
fun MainNavigation(mainViewModel: MainViewModel = viewModel()) {
    when (mainViewModel.screenState.value) {
        "home" -> HomeScreen()
        "raffle" -> RaffleScreen()
        "watch" -> WatchScreen()
        else -> HomeScreen()
    }
}
