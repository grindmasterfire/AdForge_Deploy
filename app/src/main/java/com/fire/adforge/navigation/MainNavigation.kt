package com.fire.adforge.navigation

import androidx.compose.runtime.Composable`nimport com.fire.adforge.ui.wall.BadgeWallScreen
import androidx.navigation.compose.NavHost`nimport com.fire.adforge.ui.wall.BadgeWallScreen
import androidx.navigation.compose.composable`nimport com.fire.adforge.ui.wall.BadgeWallScreen
import androidx.navigation.compose.rememberNavController`nimport com.fire.adforge.ui.wall.BadgeWallScreen
import com.fire.adforge.ui.MainScreen`nimport com.fire.adforge.ui.wall.BadgeWallScreen
import com.fire.adforge.ui.ProfileScreen`nimport com.fire.adforge.ui.wall.BadgeWallScreen
import com.fire.adforge.ui.mail.MailCenterScreen`nimport com.fire.adforge.ui.wall.BadgeWallScreen

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "main") {
        composable("main") { MainScreen(navController) }
        composable("mail") { MailCenterScreen() }
        composable("badgewall") { BadgeWallScreen() }\n        composable("profile") { ProfileScreen() }
    }
}
