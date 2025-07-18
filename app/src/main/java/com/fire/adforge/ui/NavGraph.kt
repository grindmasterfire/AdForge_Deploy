package com.fire.adforge.ui

import androidx.compose.runtime.Composable`nimport com.fire.adforge.ui.MailboxScreen`nimport com.fire.adforge.ui.CrewJoinScreen`nimport com.fire.adforge.ui.CrewLeaderboardScreen`nimport com.fire.adforge.ui.BoosterStoreScreen
import androidx.navigation.NavHostController`nimport com.fire.adforge.ui.MailboxScreen`nimport com.fire.adforge.ui.CrewJoinScreen`nimport com.fire.adforge.ui.CrewLeaderboardScreen`nimport com.fire.adforge.ui.BoosterStoreScreen
import androidx.navigation.compose.NavHost`nimport com.fire.adforge.ui.MailboxScreen`nimport com.fire.adforge.ui.CrewJoinScreen`nimport com.fire.adforge.ui.CrewLeaderboardScreen`nimport com.fire.adforge.ui.BoosterStoreScreen
import androidx.navigation.compose.composable`nimport com.fire.adforge.ui.MailboxScreen`nimport com.fire.adforge.ui.CrewJoinScreen`nimport com.fire.adforge.ui.CrewLeaderboardScreen`nimport com.fire.adforge.ui.BoosterStoreScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "main") {`n composable("mailbox") {`n composable("crew") {`n composable("crew_leaderboard") {`n composable("booster_store") { BoosterStoreScreen() } CrewLeaderboardScreen() } CrewJoinScreen() } MailboxScreen() }
        composable("main") { MainScreen(navController) }
        composable("wallet") { WalletScreen() }
        composable("wall") { PersonalWallScreen() }
    }
}
