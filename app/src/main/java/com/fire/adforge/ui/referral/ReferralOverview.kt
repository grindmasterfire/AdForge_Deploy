package com.fire.adforge.ui.referral

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ReferralOverview(downlineCounts: List<Int>) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Your Referral Network", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(12.dp))

        listOf(10, 5, 3, 1).forEachIndexed { i, rate ->
            val count = downlineCounts.getOrNull(i) ?: 0
            Text("Tier  — \%: \ referrals")
            Spacer(modifier = Modifier.height(6.dp))
        }
    }
}
