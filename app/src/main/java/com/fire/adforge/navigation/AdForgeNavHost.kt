import java.text.SimpleDateFormat`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.mail.MailCenterScreen`nimport com.fire.adforge.ui.raffle.RaffleWallScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleEntryScreen`nimport com.fire.adforge.ui.crew.CrewRaffleLoaderScreen`nimport com.fire.adforge.ui.crew.CrewRaffleDetailScreen`nimport com.fire.adforge.ui.crew.CrewRaffleAdminPanel`nimport com.fire.adforge.ui.claims.WinnerClaimScreen`nimport com.fire.adforge.ui.admin.PayoutQueueAdminScreen
import java.util.Locale`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.mail.MailCenterScreen`nimport com.fire.adforge.ui.raffle.RaffleWallScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleEntryScreen`nimport com.fire.adforge.ui.crew.CrewRaffleLoaderScreen`nimport com.fire.adforge.ui.crew.CrewRaffleDetailScreen`nimport com.fire.adforge.ui.crew.CrewRaffleAdminPanel`nimport com.fire.adforge.ui.claims.WinnerClaimScreen`nimport com.fire.adforge.ui.admin.PayoutQueueAdminScreen
import android.util.Log`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.mail.MailCenterScreen`nimport com.fire.adforge.ui.raffle.RaffleWallScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleEntryScreen`nimport com.fire.adforge.ui.crew.CrewRaffleLoaderScreen`nimport com.fire.adforge.ui.crew.CrewRaffleDetailScreen`nimport com.fire.adforge.ui.crew.CrewRaffleAdminPanel`nimport com.fire.adforge.ui.claims.WinnerClaimScreen`nimport com.fire.adforge.ui.admin.PayoutQueueAdminScreen
import androidx.compose.material3.MaterialTheme`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.mail.MailCenterScreen`nimport com.fire.adforge.ui.raffle.RaffleWallScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleEntryScreen`nimport com.fire.adforge.ui.crew.CrewRaffleLoaderScreen`nimport com.fire.adforge.ui.crew.CrewRaffleDetailScreen`nimport com.fire.adforge.ui.crew.CrewRaffleAdminPanel`nimport com.fire.adforge.ui.claims.WinnerClaimScreen`nimport com.fire.adforge.ui.admin.PayoutQueueAdminScreen
import androidx.compose.material3.Text`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.mail.MailCenterScreen`nimport com.fire.adforge.ui.raffle.RaffleWallScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleEntryScreen`nimport com.fire.adforge.ui.crew.CrewRaffleLoaderScreen`nimport com.fire.adforge.ui.crew.CrewRaffleDetailScreen`nimport com.fire.adforge.ui.crew.CrewRaffleAdminPanel`nimport com.fire.adforge.ui.claims.WinnerClaimScreen`nimport com.fire.adforge.ui.admin.PayoutQueueAdminScreen
package com.fire.adforge.navigation

import androidx.compose.runtime.Composable`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.mail.MailCenterScreen`nimport com.fire.adforge.ui.raffle.RaffleWallScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleEntryScreen`nimport com.fire.adforge.ui.crew.CrewRaffleLoaderScreen`nimport com.fire.adforge.ui.crew.CrewRaffleDetailScreen`nimport com.fire.adforge.ui.crew.CrewRaffleAdminPanel`nimport com.fire.adforge.ui.claims.WinnerClaimScreen`nimport com.fire.adforge.ui.admin.PayoutQueueAdminScreen
import androidx.navigation.compose.NavHost`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.mail.MailCenterScreen`nimport com.fire.adforge.ui.raffle.RaffleWallScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleEntryScreen`nimport com.fire.adforge.ui.crew.CrewRaffleLoaderScreen`nimport com.fire.adforge.ui.crew.CrewRaffleDetailScreen`nimport com.fire.adforge.ui.crew.CrewRaffleAdminPanel`nimport com.fire.adforge.ui.claims.WinnerClaimScreen`nimport com.fire.adforge.ui.admin.PayoutQueueAdminScreen
import androidx.navigation.compose.composable`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.mail.MailCenterScreen`nimport com.fire.adforge.ui.raffle.RaffleWallScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleEntryScreen`nimport com.fire.adforge.ui.crew.CrewRaffleLoaderScreen`nimport com.fire.adforge.ui.crew.CrewRaffleDetailScreen`nimport com.fire.adforge.ui.crew.CrewRaffleAdminPanel`nimport com.fire.adforge.ui.claims.WinnerClaimScreen`nimport com.fire.adforge.ui.admin.PayoutQueueAdminScreen
import androidx.navigation.NavHostController`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.mail.MailCenterScreen`nimport com.fire.adforge.ui.raffle.RaffleWallScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleEntryScreen`nimport com.fire.adforge.ui.crew.CrewRaffleLoaderScreen`nimport com.fire.adforge.ui.crew.CrewRaffleDetailScreen`nimport com.fire.adforge.ui.crew.CrewRaffleAdminPanel`nimport com.fire.adforge.ui.claims.WinnerClaimScreen`nimport com.fire.adforge.ui.admin.PayoutQueueAdminScreen
import com.fire.adforge.ui.*`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.mail.MailCenterScreen`nimport com.fire.adforge.ui.raffle.RaffleWallScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleEntryScreen`nimport com.fire.adforge.ui.crew.CrewRaffleLoaderScreen`nimport com.fire.adforge.ui.crew.CrewRaffleDetailScreen`nimport com.fire.adforge.ui.crew.CrewRaffleAdminPanel`nimport com.fire.adforge.ui.claims.WinnerClaimScreen`nimport com.fire.adforge.ui.admin.PayoutQueueAdminScreen
import com.fire.adforge.ui.screens.MainScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.mail.MailCenterScreen`nimport com.fire.adforge.ui.raffle.RaffleWallScreen`nimport com.fire.adforge.ui.crew.CrewScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleScreen`nimport com.fire.adforge.ui.raffle.SessionRaffleEntryScreen`nimport com.fire.adforge.ui.crew.CrewRaffleLoaderScreen`nimport com.fire.adforge.ui.crew.CrewRaffleDetailScreen`nimport com.fire.adforge.ui.crew.CrewRaffleAdminPanel`nimport com.fire.adforge.ui.claims.WinnerClaimScreen`nimport com.fire.adforge.ui.admin.PayoutQueueAdminScreen

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

composable("crewRaffleDetail/{crewName}") { backStackEntry ->
    val crewName = backStackEntry.arguments?.getString("crewName") ?: ""
    CrewRaffleDetailScreen(crewName)

composable("crewRaffleAdmin") {
    CrewRaffleAdminPanel()

composable("winnerClaim/{userId}") { backStackEntry ->
    val userId = backStackEntry.arguments?.getString("userId") ?: ""
    WinnerClaimScreen(userId)

composable("payoutAdmin") {
    PayoutQueueAdminScreen()
}







composable("raffleEntries/{sessionId}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    SessionRaffleEntryScreen(sessionId)

composable("crewRaffles") {
    CrewRaffleLoaderScreen()

composable("crewRaffleDetail/{crewName}") { backStackEntry ->
    val crewName = backStackEntry.arguments?.getString("crewName") ?: ""
    CrewRaffleDetailScreen(crewName)

composable("crewRaffleAdmin") {
    CrewRaffleAdminPanel()

composable("winnerClaim/{userId}") { backStackEntry ->
    val userId = backStackEntry.arguments?.getString("userId") ?: ""
    WinnerClaimScreen(userId)

composable("payoutAdmin") {
    PayoutQueueAdminScreen()
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

composable("crewRaffleDetail/{crewName}") { backStackEntry ->
    val crewName = backStackEntry.arguments?.getString("crewName") ?: ""
    CrewRaffleDetailScreen(crewName)

composable("crewRaffleAdmin") {
    CrewRaffleAdminPanel()

composable("winnerClaim/{userId}") { backStackEntry ->
    val userId = backStackEntry.arguments?.getString("userId") ?: ""
    WinnerClaimScreen(userId)

composable("payoutAdmin") {
    PayoutQueueAdminScreen()
}







composable("raffleEntries/{sessionId}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    SessionRaffleEntryScreen(sessionId)

composable("crewRaffles") {
    CrewRaffleLoaderScreen()

composable("crewRaffleDetail/{crewName}") { backStackEntry ->
    val crewName = backStackEntry.arguments?.getString("crewName") ?: ""
    CrewRaffleDetailScreen(crewName)

composable("crewRaffleAdmin") {
    CrewRaffleAdminPanel()

composable("winnerClaim/{userId}") { backStackEntry ->
    val userId = backStackEntry.arguments?.getString("userId") ?: ""
    WinnerClaimScreen(userId)

composable("payoutAdmin") {
    PayoutQueueAdminScreen()
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

composable("crewRaffleDetail/{crewName}") { backStackEntry ->
    val crewName = backStackEntry.arguments?.getString("crewName") ?: ""
    CrewRaffleDetailScreen(crewName)

composable("crewRaffleAdmin") {
    CrewRaffleAdminPanel()

composable("winnerClaim/{userId}") { backStackEntry ->
    val userId = backStackEntry.arguments?.getString("userId") ?: ""
    WinnerClaimScreen(userId)

composable("payoutAdmin") {
    PayoutQueueAdminScreen()
}







composable("raffleEntries/{sessionId}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    SessionRaffleEntryScreen(sessionId)

composable("crewRaffles") {
    CrewRaffleLoaderScreen()

composable("crewRaffleDetail/{crewName}") { backStackEntry ->
    val crewName = backStackEntry.arguments?.getString("crewName") ?: ""
    CrewRaffleDetailScreen(crewName)

composable("crewRaffleAdmin") {
    CrewRaffleAdminPanel()

composable("winnerClaim/{userId}") { backStackEntry ->
    val userId = backStackEntry.arguments?.getString("userId") ?: ""
    WinnerClaimScreen(userId)

composable("payoutAdmin") {
    PayoutQueueAdminScreen()
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

composable("crewRaffleDetail/{crewName}") { backStackEntry ->
    val crewName = backStackEntry.arguments?.getString("crewName") ?: ""
    CrewRaffleDetailScreen(crewName)

composable("crewRaffleAdmin") {
    CrewRaffleAdminPanel()

composable("winnerClaim/{userId}") { backStackEntry ->
    val userId = backStackEntry.arguments?.getString("userId") ?: ""
    WinnerClaimScreen(userId)

composable("payoutAdmin") {
    PayoutQueueAdminScreen()
}







composable("raffleEntries/{sessionId}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    SessionRaffleEntryScreen(sessionId)

composable("crewRaffles") {
    CrewRaffleLoaderScreen()

composable("crewRaffleDetail/{crewName}") { backStackEntry ->
    val crewName = backStackEntry.arguments?.getString("crewName") ?: ""
    CrewRaffleDetailScreen(crewName)

composable("crewRaffleAdmin") {
    CrewRaffleAdminPanel()

composable("winnerClaim/{userId}") { backStackEntry ->
    val userId = backStackEntry.arguments?.getString("userId") ?: ""
    WinnerClaimScreen(userId)

composable("payoutAdmin") {
    PayoutQueueAdminScreen()
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

composable("crewRaffleDetail/{crewName}") { backStackEntry ->
    val crewName = backStackEntry.arguments?.getString("crewName") ?: ""
    CrewRaffleDetailScreen(crewName)

composable("crewRaffleAdmin") {
    CrewRaffleAdminPanel()

composable("winnerClaim/{userId}") { backStackEntry ->
    val userId = backStackEntry.arguments?.getString("userId") ?: ""
    WinnerClaimScreen(userId)

composable("payoutAdmin") {
    PayoutQueueAdminScreen()
}







composable("raffleEntries/{sessionId}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    SessionRaffleEntryScreen(sessionId)

composable("crewRaffles") {
    CrewRaffleLoaderScreen()

composable("crewRaffleDetail/{crewName}") { backStackEntry ->
    val crewName = backStackEntry.arguments?.getString("crewName") ?: ""
    CrewRaffleDetailScreen(crewName)

composable("crewRaffleAdmin") {
    CrewRaffleAdminPanel()

composable("winnerClaim/{userId}") { backStackEntry ->
    val userId = backStackEntry.arguments?.getString("userId") ?: ""
    WinnerClaimScreen(userId)

composable("payoutAdmin") {
    PayoutQueueAdminScreen()
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

composable("crewRaffleDetail/{crewName}") { backStackEntry ->
    val crewName = backStackEntry.arguments?.getString("crewName") ?: ""
    CrewRaffleDetailScreen(crewName)

composable("crewRaffleAdmin") {
    CrewRaffleAdminPanel()

composable("winnerClaim/{userId}") { backStackEntry ->
    val userId = backStackEntry.arguments?.getString("userId") ?: ""
    WinnerClaimScreen(userId)

composable("payoutAdmin") {
    PayoutQueueAdminScreen()
}







composable("raffleEntries/{sessionId}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    SessionRaffleEntryScreen(sessionId)

composable("crewRaffles") {
    CrewRaffleLoaderScreen()

composable("crewRaffleDetail/{crewName}") { backStackEntry ->
    val crewName = backStackEntry.arguments?.getString("crewName") ?: ""
    CrewRaffleDetailScreen(crewName)

composable("crewRaffleAdmin") {
    CrewRaffleAdminPanel()

composable("winnerClaim/{userId}") { backStackEntry ->
    val userId = backStackEntry.arguments?.getString("userId") ?: ""
    WinnerClaimScreen(userId)

composable("payoutAdmin") {
    PayoutQueueAdminScreen()
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

composable("crewRaffleDetail/{crewName}") { backStackEntry ->
    val crewName = backStackEntry.arguments?.getString("crewName") ?: ""
    CrewRaffleDetailScreen(crewName)

composable("crewRaffleAdmin") {
    CrewRaffleAdminPanel()

composable("winnerClaim/{userId}") { backStackEntry ->
    val userId = backStackEntry.arguments?.getString("userId") ?: ""
    WinnerClaimScreen(userId)

composable("payoutAdmin") {
    PayoutQueueAdminScreen()
}







composable("raffleEntries/{sessionId}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    SessionRaffleEntryScreen(sessionId)

composable("crewRaffles") {
    CrewRaffleLoaderScreen()

composable("crewRaffleDetail/{crewName}") { backStackEntry ->
    val crewName = backStackEntry.arguments?.getString("crewName") ?: ""
    CrewRaffleDetailScreen(crewName)

composable("crewRaffleAdmin") {
    CrewRaffleAdminPanel()

composable("winnerClaim/{userId}") { backStackEntry ->
    val userId = backStackEntry.arguments?.getString("userId") ?: ""
    WinnerClaimScreen(userId)

composable("payoutAdmin") {
    PayoutQueueAdminScreen()
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

composable("crewRaffleDetail/{crewName}") { backStackEntry ->
    val crewName = backStackEntry.arguments?.getString("crewName") ?: ""
    CrewRaffleDetailScreen(crewName)

composable("crewRaffleAdmin") {
    CrewRaffleAdminPanel()

composable("winnerClaim/{userId}") { backStackEntry ->
    val userId = backStackEntry.arguments?.getString("userId") ?: ""
    WinnerClaimScreen(userId)

composable("payoutAdmin") {
    PayoutQueueAdminScreen()
}







composable("raffleEntries/{sessionId}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    SessionRaffleEntryScreen(sessionId)

composable("crewRaffles") {
    CrewRaffleLoaderScreen()

composable("crewRaffleDetail/{crewName}") { backStackEntry ->
    val crewName = backStackEntry.arguments?.getString("crewName") ?: ""
    CrewRaffleDetailScreen(crewName)

composable("crewRaffleAdmin") {
    CrewRaffleAdminPanel()

composable("winnerClaim/{userId}") { backStackEntry ->
    val userId = backStackEntry.arguments?.getString("userId") ?: ""
    WinnerClaimScreen(userId)

composable("payoutAdmin") {
    PayoutQueueAdminScreen()
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

composable("crewRaffleDetail/{crewName}") { backStackEntry ->
    val crewName = backStackEntry.arguments?.getString("crewName") ?: ""
    CrewRaffleDetailScreen(crewName)

composable("crewRaffleAdmin") {
    CrewRaffleAdminPanel()

composable("winnerClaim/{userId}") { backStackEntry ->
    val userId = backStackEntry.arguments?.getString("userId") ?: ""
    WinnerClaimScreen(userId)

composable("payoutAdmin") {
    PayoutQueueAdminScreen()
}







composable("raffleEntries/{sessionId}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    SessionRaffleEntryScreen(sessionId)

composable("crewRaffles") {
    CrewRaffleLoaderScreen()

composable("crewRaffleDetail/{crewName}") { backStackEntry ->
    val crewName = backStackEntry.arguments?.getString("crewName") ?: ""
    CrewRaffleDetailScreen(crewName)

composable("crewRaffleAdmin") {
    CrewRaffleAdminPanel()

composable("winnerClaim/{userId}") { backStackEntry ->
    val userId = backStackEntry.arguments?.getString("userId") ?: ""
    WinnerClaimScreen(userId)

composable("payoutAdmin") {
    PayoutQueueAdminScreen()
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

composable("crewRaffleDetail/{crewName}") { backStackEntry ->
    val crewName = backStackEntry.arguments?.getString("crewName") ?: ""
    CrewRaffleDetailScreen(crewName)

composable("crewRaffleAdmin") {
    CrewRaffleAdminPanel()

composable("winnerClaim/{userId}") { backStackEntry ->
    val userId = backStackEntry.arguments?.getString("userId") ?: ""
    WinnerClaimScreen(userId)

composable("payoutAdmin") {
    PayoutQueueAdminScreen()
}







composable("raffleEntries/{sessionId}") { backStackEntry ->
    val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
    SessionRaffleEntryScreen(sessionId)

composable("crewRaffles") {
    CrewRaffleLoaderScreen()

composable("crewRaffleDetail/{crewName}") { backStackEntry ->
    val crewName = backStackEntry.arguments?.getString("crewName") ?: ""
    CrewRaffleDetailScreen(crewName)

composable("crewRaffleAdmin") {
    CrewRaffleAdminPanel()

composable("winnerClaim/{userId}") { backStackEntry ->
    val userId = backStackEntry.arguments?.getString("userId") ?: ""
    WinnerClaimScreen(userId)

composable("payoutAdmin") {
    PayoutQueueAdminScreen()
}








