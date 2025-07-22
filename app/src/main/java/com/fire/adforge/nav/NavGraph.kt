package com.fire.adforge.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fire.adforge.ui.home.MainScreen
import com.fire.adforge.ui.breadloop.BreadloopScreen
import com.fire.adforge.ui.raffle.RaffleHistoryScreen
import com.fire.adforge.ui.referral.ReferralScreen
import com.fire.adforge.ui.milestone.BoosterScreen
import com.fire.adforge.ui.crew.CrewDashboard
import com.fire.adforge.ui.clan.ClanViewScreen
import com.fire.adforge.ui.special.CipherBotWallScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "main") {
        composable("main") { MainScreen() }
        composable("breadloop") { BreadloopScreen() }
        composable("raffles") { RaffleHistoryScreen() }
        composable("referrals") { ReferralScreen() }
        composable("milestones") { BoosterScreen() }
        composable("crew") { CrewDashboard() }
        composable("clan") { ClanViewScreen() }
        composable("cipherbot") { CipherBotWallScreen() }
    }
}
