import java.text.SimpleDateFormat`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.mail.MailCenterScreen`nimport com.fire.adforge.ui.raffle.RaffleWallScreen`nimport com.fire.adforge.ui.crew.CrewScreen
import java.util.Locale`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.mail.MailCenterScreen`nimport com.fire.adforge.ui.raffle.RaffleWallScreen`nimport com.fire.adforge.ui.crew.CrewScreen
import android.util.Log`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.mail.MailCenterScreen`nimport com.fire.adforge.ui.raffle.RaffleWallScreen`nimport com.fire.adforge.ui.crew.CrewScreen
import androidx.compose.material3.MaterialTheme`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.mail.MailCenterScreen`nimport com.fire.adforge.ui.raffle.RaffleWallScreen`nimport com.fire.adforge.ui.crew.CrewScreen
import androidx.compose.material3.Text`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.mail.MailCenterScreen`nimport com.fire.adforge.ui.raffle.RaffleWallScreen`nimport com.fire.adforge.ui.crew.CrewScreen
package com.fire.adforge.navigation

import androidx.compose.runtime.Composable`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.mail.MailCenterScreen`nimport com.fire.adforge.ui.raffle.RaffleWallScreen`nimport com.fire.adforge.ui.crew.CrewScreen
import androidx.navigation.compose.NavHost`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.mail.MailCenterScreen`nimport com.fire.adforge.ui.raffle.RaffleWallScreen`nimport com.fire.adforge.ui.crew.CrewScreen
import androidx.navigation.compose.composable`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.mail.MailCenterScreen`nimport com.fire.adforge.ui.raffle.RaffleWallScreen`nimport com.fire.adforge.ui.crew.CrewScreen
import androidx.navigation.NavHostController`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.mail.MailCenterScreen`nimport com.fire.adforge.ui.raffle.RaffleWallScreen`nimport com.fire.adforge.ui.crew.CrewScreen
import com.fire.adforge.ui.*`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.mail.MailCenterScreen`nimport com.fire.adforge.ui.raffle.RaffleWallScreen`nimport com.fire.adforge.ui.crew.CrewScreen
import com.fire.adforge.ui.screens.MainScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.mail.MailCenterScreen`nimport com.fire.adforge.ui.raffle.RaffleWallScreen`nimport com.fire.adforge.ui.crew.CrewScreen

@Composable
fun AdForgeNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "main") {
        composable("raffle") { RaffleScreen() }
        composable("raffle") { RaffleScreen() }
        composable("raffle") { RaffleScreen() }
        composable("raffle") { RaffleScreen() }
        composable("raffle") { RaffleScreen() }
        composable("raffle") { RaffleScreen() }
        composable("raffle") { RaffleScreen() }
        composable("raffle") { RaffleScreen() }
    }
}

