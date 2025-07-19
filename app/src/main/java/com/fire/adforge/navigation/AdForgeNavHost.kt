import java.text.SimpleDateFormat`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.mail.MailCenterScreen`nimport com.fire.adforge.ui.raffle.RaffleWallScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleEntryScreen`nimport com.fire.adforge.ui.crew.CrewRaffleLoaderScreen
import java.util.Locale`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.mail.MailCenterScreen`nimport com.fire.adforge.ui.raffle.RaffleWallScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleEntryScreen`nimport com.fire.adforge.ui.crew.CrewRaffleLoaderScreen
import android.util.Log`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.mail.MailCenterScreen`nimport com.fire.adforge.ui.raffle.RaffleWallScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleEntryScreen`nimport com.fire.adforge.ui.crew.CrewRaffleLoaderScreen
import androidx.compose.material3.MaterialTheme`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.mail.MailCenterScreen`nimport com.fire.adforge.ui.raffle.RaffleWallScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleEntryScreen`nimport com.fire.adforge.ui.crew.CrewRaffleLoaderScreen
import androidx.compose.material3.Text`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.mail.MailCenterScreen`nimport com.fire.adforge.ui.raffle.RaffleWallScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleEntryScreen`nimport com.fire.adforge.ui.crew.CrewRaffleLoaderScreen
package com.fire.adforge.navigation

import androidx.compose.runtime.Composable`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.mail.MailCenterScreen`nimport com.fire.adforge.ui.raffle.RaffleWallScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleEntryScreen`nimport com.fire.adforge.ui.crew.CrewRaffleLoaderScreen
import androidx.navigation.compose.NavHost`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.mail.MailCenterScreen`nimport com.fire.adforge.ui.raffle.RaffleWallScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleEntryScreen`nimport com.fire.adforge.ui.crew.CrewRaffleLoaderScreen
import androidx.navigation.compose.composable`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.mail.MailCenterScreen`nimport com.fire.adforge.ui.raffle.RaffleWallScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleEntryScreen`nimport com.fire.adforge.ui.crew.CrewRaffleLoaderScreen
import androidx.navigation.NavHostController`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.mail.MailCenterScreen`nimport com.fire.adforge.ui.raffle.RaffleWallScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleEntryScreen`nimport com.fire.adforge.ui.crew.CrewRaffleLoaderScreen
import com.fire.adforge.ui.*`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.mail.MailCenterScreen`nimport com.fire.adforge.ui.raffle.RaffleWallScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleEntryScreen`nimport com.fire.adforge.ui.crew.CrewRaffleLoaderScreen
import com.fire.adforge.ui.screens.MainScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.mail.MailCenterScreen`nimport com.fire.adforge.ui.raffle.RaffleWallScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleEntryScreen`nimport com.fire.adforge.ui.crew.CrewRaffleLoaderScreen

@Composable
fun AdForgeNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "main") {
        composable("raffle") { RaffleScreen()
composable("sessionRaffle/{sessionId}/{userId}/{coinBalance}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    val userId = backStackEntry.arguments?.getString("userId") ?: ""
    val coins = backStackEntry.arguments?.getString("coinBalance")?.toIntOrNull() ?: 0
    SessionRaffleScreen(sessionId, userId, coins) {
composable("raffleEntries/{sessionId}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    SessionRaffleEntryScreen(sessionId)

composable("crewRaffles") {
    CrewRaffleLoaderScreen()
}



composable("raffleEntries/{sessionId}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    SessionRaffleEntryScreen(sessionId)

composable("crewRaffles") {
    CrewRaffleLoaderScreen()
}



        composable("raffle") { RaffleScreen()
composable("sessionRaffle/{sessionId}/{userId}/{coinBalance}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    val userId = backStackEntry.arguments?.getString("userId") ?: ""
    val coins = backStackEntry.arguments?.getString("coinBalance")?.toIntOrNull() ?: 0
    SessionRaffleScreen(sessionId, userId, coins) {
composable("raffleEntries/{sessionId}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    SessionRaffleEntryScreen(sessionId)

composable("crewRaffles") {
    CrewRaffleLoaderScreen()
}



composable("raffleEntries/{sessionId}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    SessionRaffleEntryScreen(sessionId)

composable("crewRaffles") {
    CrewRaffleLoaderScreen()
}



        composable("raffle") { RaffleScreen()
composable("sessionRaffle/{sessionId}/{userId}/{coinBalance}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    val userId = backStackEntry.arguments?.getString("userId") ?: ""
    val coins = backStackEntry.arguments?.getString("coinBalance")?.toIntOrNull() ?: 0
    SessionRaffleScreen(sessionId, userId, coins) {
composable("raffleEntries/{sessionId}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    SessionRaffleEntryScreen(sessionId)

composable("crewRaffles") {
    CrewRaffleLoaderScreen()
}



composable("raffleEntries/{sessionId}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    SessionRaffleEntryScreen(sessionId)

composable("crewRaffles") {
    CrewRaffleLoaderScreen()
}



        composable("raffle") { RaffleScreen()
composable("sessionRaffle/{sessionId}/{userId}/{coinBalance}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    val userId = backStackEntry.arguments?.getString("userId") ?: ""
    val coins = backStackEntry.arguments?.getString("coinBalance")?.toIntOrNull() ?: 0
    SessionRaffleScreen(sessionId, userId, coins) {
composable("raffleEntries/{sessionId}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    SessionRaffleEntryScreen(sessionId)

composable("crewRaffles") {
    CrewRaffleLoaderScreen()
}



composable("raffleEntries/{sessionId}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    SessionRaffleEntryScreen(sessionId)

composable("crewRaffles") {
    CrewRaffleLoaderScreen()
}



        composable("raffle") { RaffleScreen()
composable("sessionRaffle/{sessionId}/{userId}/{coinBalance}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    val userId = backStackEntry.arguments?.getString("userId") ?: ""
    val coins = backStackEntry.arguments?.getString("coinBalance")?.toIntOrNull() ?: 0
    SessionRaffleScreen(sessionId, userId, coins) {
composable("raffleEntries/{sessionId}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    SessionRaffleEntryScreen(sessionId)

composable("crewRaffles") {
    CrewRaffleLoaderScreen()
}



composable("raffleEntries/{sessionId}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    SessionRaffleEntryScreen(sessionId)

composable("crewRaffles") {
    CrewRaffleLoaderScreen()
}



        composable("raffle") { RaffleScreen()
composable("sessionRaffle/{sessionId}/{userId}/{coinBalance}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    val userId = backStackEntry.arguments?.getString("userId") ?: ""
    val coins = backStackEntry.arguments?.getString("coinBalance")?.toIntOrNull() ?: 0
    SessionRaffleScreen(sessionId, userId, coins) {
composable("raffleEntries/{sessionId}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    SessionRaffleEntryScreen(sessionId)

composable("crewRaffles") {
    CrewRaffleLoaderScreen()
}



composable("raffleEntries/{sessionId}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    SessionRaffleEntryScreen(sessionId)

composable("crewRaffles") {
    CrewRaffleLoaderScreen()
}



        composable("raffle") { RaffleScreen()
composable("sessionRaffle/{sessionId}/{userId}/{coinBalance}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    val userId = backStackEntry.arguments?.getString("userId") ?: ""
    val coins = backStackEntry.arguments?.getString("coinBalance")?.toIntOrNull() ?: 0
    SessionRaffleScreen(sessionId, userId, coins) {
composable("raffleEntries/{sessionId}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    SessionRaffleEntryScreen(sessionId)

composable("crewRaffles") {
    CrewRaffleLoaderScreen()
}



composable("raffleEntries/{sessionId}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    SessionRaffleEntryScreen(sessionId)

composable("crewRaffles") {
    CrewRaffleLoaderScreen()
}



        composable("raffle") { RaffleScreen()
composable("sessionRaffle/{sessionId}/{userId}/{coinBalance}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    val userId = backStackEntry.arguments?.getString("userId") ?: ""
    val coins = backStackEntry.arguments?.getString("coinBalance")?.toIntOrNull() ?: 0
    SessionRaffleScreen(sessionId, userId, coins) {
composable("raffleEntries/{sessionId}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    SessionRaffleEntryScreen(sessionId)

composable("crewRaffles") {
    CrewRaffleLoaderScreen()
}



composable("raffleEntries/{sessionId}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    SessionRaffleEntryScreen(sessionId)

composable("crewRaffles") {
    CrewRaffleLoaderScreen()
}




composable("sessionRaffle/{sessionId}/{userId}/{coinBalance}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    val userId = backStackEntry.arguments?.getString("userId") ?: ""
    val coins = backStackEntry.arguments?.getString("coinBalance")?.toIntOrNull() ?: 0
    SessionRaffleScreen(sessionId, userId, coins) {
composable("raffleEntries/{sessionId}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    SessionRaffleEntryScreen(sessionId)

composable("crewRaffles") {
    CrewRaffleLoaderScreen()
}



composable("raffleEntries/{sessionId}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    SessionRaffleEntryScreen(sessionId)

composable("crewRaffles") {
    CrewRaffleLoaderScreen()
}




composable("sessionRaffle/{sessionId}/{userId}/{coinBalance}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    val userId = backStackEntry.arguments?.getString("userId") ?: ""
    val coins = backStackEntry.arguments?.getString("coinBalance")?.toIntOrNull() ?: 0
    SessionRaffleScreen(sessionId, userId, coins) {
composable("raffleEntries/{sessionId}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    SessionRaffleEntryScreen(sessionId)

composable("crewRaffles") {
    CrewRaffleLoaderScreen()
}



composable("raffleEntries/{sessionId}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    SessionRaffleEntryScreen(sessionId)

composable("crewRaffles") {
    CrewRaffleLoaderScreen()
}




