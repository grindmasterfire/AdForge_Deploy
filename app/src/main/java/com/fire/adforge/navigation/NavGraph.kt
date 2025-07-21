package com.fire.adforge.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fire.adforge.ui.profile.PersonalWallScreen
import com.fire.adforge.ui.crew.CrewWallScreen
import com.fire.adforge.ui.clan.ClanWallScreen

@Composable
fun AppNavGraph(navController: NavHostController, startDestination: String = "home") {
    NavHost(navController = navController, startDestination = startDestination) {
        composable("personal_wall") {
            PersonalWallScreen(userId = "currentUserId") // replace with real user ID
        }
        composable("crew_wall") {
            CrewWallScreen(crewId = "currentCrewId") // replace with real crew ID
        }
        composable("clan_wall") {
            ClanWallScreen(clanId = "currentClanId") // replace with real clan ID
        }
    }
}
