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
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.delay

@Composable
fun RewardVelocityDebug(offerId: String) {
    val db = FirebaseFirestore.getInstance()
    var coins by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        while (true) {
            db.collection("milestones").document(offerId).get().addOnSuccessListener {
                coins = it.getLong("boosts")?.toInt() ?: 0
            }
            delay(5000)
        }
    }

    Column(Modifier.padding(20.dp)) {
        Text("Live Milestone Velocity", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(8.dp))
        Text("Current Pool: $coins coins")
    }
}

