import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun UserEarningsDashboard() {
    val uid = FirebaseAuth.getInstance().currentUser?.uid ?: "anon"
    val db = FirebaseFirestore.getInstance()

    var earned by remember { mutableStateOf(0) }
    var spent by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        db.collection("users").document(uid).get().addOnSuccessListener {
            earned = it.getLong("totalEarned")?.toInt() ?: 0
            spent = it.getLong("totalSpent")?.toInt() ?: 0
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(20.dp)) {
        Text("Your Earnings", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(12.dp))
        Text("Coins Earned: $earned")
        Text("Coins Spent: $spent")
        Text("Net: ${earned - spent}")
    }
}

