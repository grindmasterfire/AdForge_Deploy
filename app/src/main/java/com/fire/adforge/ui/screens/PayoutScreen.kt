import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fire.adforge.models.UserAccount

@Composable
fun PayoutScreen(user: UserAccount) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp)) {

        Text("💸 Redeem Coins", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        if (user.isAdult) {
            Button(onClick = { /* Trigger PayPal */ }) {
                Text("PayPal")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { /* Trigger Venmo */ }) {
                Text("Venmo")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { /* Trigger CashApp */ }) {
                Text("CashApp")
            }
        } else {
            Text("⚠️ Age-restricted payout methods are hidden.", style = MaterialTheme.typography.bodyMedium)
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /* Trigger Google Play Points */ }) {
            Text("Google Play Points")
        }
    }
}

