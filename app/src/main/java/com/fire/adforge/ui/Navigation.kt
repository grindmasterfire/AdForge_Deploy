import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import androidx.compose.runtime.Composable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.fire.adforge.ui.screens.*
import com.fire.adforge.viewmodel.*

sealed class Screen(val route: String) {
    object Main : Screen("main")
    object WatchAd : Screen("watchAd")
    object CrewLog : Screen("crewLog")
    // Add more routes here
}

@Composable
fun AdForgeNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Screen.Main.route) {

        composable(Screen.Main.route) {
            MainScreen(navController = navController)
        }

        composable(Screen.WatchAd.route) {
            WatchAdScreen()
        }

        composable(Screen.CrewLog.route) {
            CrewLogScreen()
        }

        // More composable screens can be added here
    }
}

