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
fun ReferralTreeVisualizer() {
    val db = FirebaseFirestore.getInstance()
    val uid = FirebaseAuth.getInstance().currentUser?.uid ?: "anon"
    var levels by remember { mutableStateOf(mapOf<Int, Int>()) }

    LaunchedEffect(Unit) {
        val temp = mutableMapOf<Int, Int>()
        db.collection("referrals").document(uid).get().addOnSuccessListener {
            temp[1] = (it.get("tier1") as? List<*>)?.size ?: 0
            temp[2] = (it.get("tier2") as? List<*>)?.size ?: 0
            temp[3] = (it.get("tier3") as? List<*>)?.size ?: 0
            temp[4] = (it.get("tier4") as? List<*>)?.size ?: 0
            levels = temp
        }
    }

    Column(Modifier.fillMaxSize().padding(20.dp)) {
        Text("Your Referral Tree", style = MaterialTheme.typography.titleLarge)
        for (tier in 1..4) {
            Text("Tier $tier: ${levels[tier] ?: 0} users")
        }
    }
}

