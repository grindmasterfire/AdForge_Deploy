package com.fire.adforge.navigation

import androidx.compose.runtime.Composable`nimport com.fire.adforge.ui.wall.BadgeWallScreen
import com.fire.adforge.ui.referral.ReferralScreen
import com.fire.adforge.ui.milestone.BoosterScreen
import com.fire.adforge.ui.crew.CrewDashboard
import com.fire.adforge.ui.clan.ClanViewScreen
import androidx.navigation.compose.NavHost`nimport com.fire.adforge.ui.wall.BadgeWallScreen
import com.fire.adforge.ui.referral.ReferralScreen
import com.fire.adforge.ui.milestone.BoosterScreen
import com.fire.adforge.ui.crew.CrewDashboard
import com.fire.adforge.ui.clan.ClanViewScreen
import androidx.navigation.compose.composable`nimport com.fire.adforge.ui.wall.BadgeWallScreen
import com.fire.adforge.ui.referral.ReferralScreen
import com.fire.adforge.ui.milestone.BoosterScreen
import com.fire.adforge.ui.crew.CrewDashboard
import com.fire.adforge.ui.clan.ClanViewScreen
import androidx.navigation.compose.rememberNavController`nimport com.fire.adforge.ui.wall.BadgeWallScreen
import com.fire.adforge.ui.referral.ReferralScreen
import com.fire.adforge.ui.milestone.BoosterScreen
import com.fire.adforge.ui.crew.CrewDashboard
import com.fire.adforge.ui.clan.ClanViewScreen
import com.fire.adforge.ui.MainScreen`nimport com.fire.adforge.ui.wall.BadgeWallScreen
import com.fire.adforge.ui.referral.ReferralScreen
import com.fire.adforge.ui.milestone.BoosterScreen
import com.fire.adforge.ui.crew.CrewDashboard
import com.fire.adforge.ui.clan.ClanViewScreen
import com.fire.adforge.ui.ProfileScreen`nimport com.fire.adforge.ui.wall.BadgeWallScreen
import com.fire.adforge.ui.referral.ReferralScreen
import com.fire.adforge.ui.milestone.BoosterScreen
import com.fire.adforge.ui.crew.CrewDashboard
import com.fire.adforge.ui.clan.ClanViewScreen
import com.fire.adforge.ui.mail.MailCenterScreen`nimport com.fire.adforge.ui.wall.BadgeWallScreen
import com.fire.adforge.ui.referral.ReferralScreen
import com.fire.adforge.ui.milestone.BoosterScreen
import com.fire.adforge.ui.crew.CrewDashboard
import com.fire.adforge.ui.clan.ClanViewScreen

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "main") {
        composable("referral") { ReferralScreen() }
        composable("booster") { BoosterScreen() }
        composable("crew") { CrewDashboard() }
        composable("clan") { ClanViewScreen() }
        composable("main") { MainScreen(navController) }
        composable("mail") { MailCenterScreen() }
        composable("badgewall") { BadgeWallScreen() }\n        composable("profile") { ProfileScreen() }
    }
}
