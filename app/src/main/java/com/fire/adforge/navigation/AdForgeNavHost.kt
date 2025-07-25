package com.fire.adforge.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

@Composable
fun AdForgeNavHost(startDestination: String = "home") {
    val navController = rememberNavController()
    println("AdForgeNavHost active")
    NavHost(navController = navController, startDestination = startDestination) {
        adForgeGraph(navController)
    }
}

// Separated logic to avoid recursion
fun NavGraphBuilder.adForgeGraph(navController: androidx.navigation.NavHostController) {
    composable("home") {
        HomeScreen(navController)
    }
    composable("rewards") {
        RewardsScreen(navController)
    }
    // Add other routes here without calling AdForgeNavHost()
}
