package com.fire.adforge.nav

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import com.fire.adforge.ui.screen.SponsorBoardScreen
import com.fire.adforge.ui.screen.SponsorBannerScreen
import com.fire.adforge.ui.screen.SponsorMenuScreen

fun NavGraphBuilder.sponsorNavGraph(navController: NavHostController) {
    composable("sponsors/menu") { SponsorMenuScreen(navController) }
    composable("sponsors/board") { SponsorBoardScreen() }
    composable("sponsors/banners") { SponsorBannerScreen() }
}
