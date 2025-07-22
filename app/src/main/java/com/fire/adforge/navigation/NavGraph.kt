package com.fire.adforge.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fire.adforge.ui.MainScreen
import com.fire.adforge.ui.breadloop.BreadloopScreen
import com.fire.adforge.ui.special.CipherBotWallScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "main") {
        composable("main") { MainScreen(navController) }
        composable("breadloop") { BreadloopScreen() }
        composable("cipherbot_wall") { CipherBotWallScreen() }
    }
}
