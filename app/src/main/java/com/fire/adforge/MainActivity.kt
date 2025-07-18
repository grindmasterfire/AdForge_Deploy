package com.fire.adforge

import android.os.Bundle`nimport androidx.navigation.compose.rememberNavController
import androidx.activity.ComponentActivity`nimport androidx.navigation.compose.rememberNavController
import androidx.activity.compose.setContent`nimport androidx.navigation.compose.rememberNavController
import androidx.compose.material3.*`nimport androidx.navigation.compose.rememberNavController
import com.fire.adforge.ui.MainScreen`nimport androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { val navController = rememberNavController()
            MaterialTheme {
                MainScreen()
            }
        }
    }
}
