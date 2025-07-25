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
        addMainRoutes(navController)
    }
}

fun NavGraphBuilder.addMainRoutes(navController: NavHostController) {
    addHomeScreen(navController)
    addRewardsScreen(navController)
    addMilestoneScreen(navController)
    addPayoutScreen(navController)
    addCrewScreen(navController)
}

fun NavGraphBuilder.addHomeScreen(navController: NavHostController) {
    composable("home") {
        HomeScreen(navController)
    }
}

fun NavGraphBuilder.addRewardsScreen(navController: NavHostController) {
    composable("rewards") {
        RewardsScreen(navController)
    }
}

fun NavGraphBuilder.addMilestoneScreen(navController: NavHostController) {
    composable("milestones") {
        MilestoneScreen(navController)
    }
}

fun NavGraphBuilder.addPayoutScreen(navController: NavHostController) {
    composable("payout") {
        PayoutScreen(navController)
    }
}

fun NavGraphBuilder.addCrewScreen(navController: NavHostController) {
    composable("crew") {
        CrewScreen(navController)
    }
}
