package com.fire.adforge

import android.os.Bundle`nimport com.google.firebase.auth.FirebaseAuth`nimport com.fire.adforge.viewmodel.UserViewModel`nimport com.google.firebase.auth.FirebaseAuth
import androidx.activity.ComponentActivity`nimport com.google.firebase.auth.FirebaseAuth`nimport com.fire.adforge.viewmodel.UserViewModel`nimport com.google.firebase.auth.FirebaseAuth
import androidx.activity.compose.setContent`nimport com.google.firebase.auth.FirebaseAuth`nimport com.fire.adforge.viewmodel.UserViewModel`nimport com.google.firebase.auth.FirebaseAuth
import androidx.compose.material3.MaterialTheme`nimport com.google.firebase.auth.FirebaseAuth`nimport com.fire.adforge.viewmodel.UserViewModel`nimport com.google.firebase.auth.FirebaseAuth
import androidx.navigation.compose.rememberNavController`nimport com.google.firebase.auth.FirebaseAuth`nimport com.fire.adforge.viewmodel.UserViewModel`nimport com.google.firebase.auth.FirebaseAuth
import com.fire.adforge.ui.MainScreen`nimport com.google.firebase.auth.FirebaseAuth`nimport com.fire.adforge.viewmodel.UserViewModel`nimport com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val auth = FirebaseAuth.getInstance()`n        setContent {
            val navController = rememberNavController()
            MaterialTheme {
                MainScreen(navController = navController)
            }
        }
    }
}
