import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.navigation

sealed class Screen(val route: String) {
    object Main : Screen("main_screen")
    object Raffle : Screen("raffle_screen")
}

