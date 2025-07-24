package com.adforge.screens

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.adforge.viewmodels.MainViewModel
import com.adforge.navigation.MainNavigation

@Composable
fun MainScreen(mainViewModel: MainViewModel = viewModel()) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("AdForge") })
        }
    ) {
        MainNavigation(mainViewModel)
    }
}
