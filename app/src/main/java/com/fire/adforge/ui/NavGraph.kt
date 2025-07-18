package com.fire.adforge.ui

import androidx.compose.runtime.Composable`nimport com.fire.adforge.ui.MailboxScreen`nimport com.fire.adforge.ui.CrewJoinScreen`nimport com.fire.adforge.ui.CrewLeaderboardScreen`nimport com.fire.adforge.ui.BoosterStoreScreen`nimport com.fire.adforge.ui.BoosterHistoryScreen`nimport com.fire.adforge.ui.SurveyEntryScreen
import androidx.navigation.NavHostController`nimport com.fire.adforge.ui.MailboxScreen`nimport com.fire.adforge.ui.CrewJoinScreen`nimport com.fire.adforge.ui.CrewLeaderboardScreen`nimport com.fire.adforge.ui.BoosterStoreScreen`nimport com.fire.adforge.ui.BoosterHistoryScreen`nimport com.fire.adforge.ui.SurveyEntryScreen
import androidx.navigation.compose.NavHost`nimport com.fire.adforge.ui.MailboxScreen`nimport com.fire.adforge.ui.CrewJoinScreen`nimport com.fire.adforge.ui.CrewLeaderboardScreen`nimport com.fire.adforge.ui.BoosterStoreScreen`nimport com.fire.adforge.ui.BoosterHistoryScreen`nimport com.fire.adforge.ui.SurveyEntryScreen
import androidx.navigation.compose.composable`nimport com.fire.adforge.ui.MailboxScreen`nimport com.fire.adforge.ui.CrewJoinScreen`nimport com.fire.adforge.ui.CrewLeaderboardScreen`nimport com.fire.adforge.ui.BoosterStoreScreen`nimport com.fire.adforge.ui.BoosterHistoryScreen`nimport com.fire.adforge.ui.SurveyEntryScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "main") {`n composable("mailbox") {`n composable("crew") {`n composable("crew_leaderboard") {`n composable("booster_store") {`n composable("booster_history") {`n composable("survey_entry") { SurveyEntryScreen() } BoosterHistoryScreen() } BoosterStoreScreen() } CrewLeaderboardScreen() } CrewJoinScreen() } MailboxScreen() }
        composable("main") { MainScreen(navController) }
        composable("wallet") { WalletScreen() }
        composable("wall") { PersonalWallScreen() }
    }
}
