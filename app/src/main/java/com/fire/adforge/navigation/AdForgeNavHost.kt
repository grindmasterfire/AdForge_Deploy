package com.fire.adforge.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AdForgeNavHost(startDestination: String = "home") {
    val navController = rememberNavController()
    println("AdForgeNavHost active")
    NavHost(navController = navController, startDestination = startDestination) {
        addAdForgeGraph(navController)
    }
}

fun NavGraphBuilder.addAdForgeGraph(navController: NavHostController) {
    composable("home") { AdForgeHomeDestination(navController) }
    composable("rewards") { AdForgeRewardsDestination(navController) }
    composable("milestones") { AdForgeMilestoneDestination(navController) }
    composable("payout") { AdForgePayoutDestination(navController) }
    composable("crew") { AdForgeCrewDestination(navController) }
    // Add more routed screens here as needed
}

@Composable
fun AdForgeHomeDestination(navController: NavHostController) {
    HomeScreen(navController)
}

@Composable
fun AdForgeRewardsDestination(navController: NavHostController) {
    RewardsScreen(navController)
}

@Composable
fun AdForgeMilestoneDestination(navController: NavHostController) {
    MilestoneScreen(navController)
}

@Composable
fun AdForgePayoutDestination(navController: NavHostController) {
    PayoutScreen(navController)
}

@Composable
fun AdForgeCrewDestination(navController: NavHostController) {
    CrewScreen(navController)
}
