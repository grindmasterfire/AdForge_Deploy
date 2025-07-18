package com.fire.adforge.ui

import androidx.compose.runtime.Composable`nimport com.fire.adforge.ui.MailboxScreen
import androidx.navigation.NavHostController`nimport com.fire.adforge.ui.MailboxScreen
import androidx.navigation.compose.NavHost`nimport com.fire.adforge.ui.MailboxScreen
import androidx.navigation.compose.composable`nimport com.fire.adforge.ui.MailboxScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "main") {`n composable("mailbox") { MailboxScreen() }
        composable("main") { MainScreen(navController) }
        composable("wallet") { WalletScreen() }
        composable("wall") { PersonalWallScreen() }
    }
}
