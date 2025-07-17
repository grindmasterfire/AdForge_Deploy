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
import kotlinx.coroutines.tasks.await

data class ReferralNode(val userId: String = "", val tier: Int = 1)

@Composable
fun ReferralTreeScreen() {
    val db = FirebaseFirestore.getInstance()
    val userId = FirebaseAuth.getInstance().currentUser?.uid ?: return
    var referrals by remember { mutableStateOf<List<ReferralNode>>(emptyList()) }

    LaunchedEffect(Unit) {
        val snap = db.collection("users")
            .document(userId)
            .collection("referrals")
            .get()
            .await()

        referrals = snap.documents.mapNotNull {
            val uid = it.getString("userId") ?: return@mapNotNull null
            val tier = it.getLong("tier")?.toInt() ?: 1
            ReferralNode(uid, tier)
        }
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text("🌳 Referral Tree", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(12.dp))

        referrals.groupBy { it.tier }.toSortedMap().forEach { (tier, group) ->
            Text("Tier ", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))

            group.forEach { node ->
                Text("- ", style = MaterialTheme.typography.bodyMedium)
            }

            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

