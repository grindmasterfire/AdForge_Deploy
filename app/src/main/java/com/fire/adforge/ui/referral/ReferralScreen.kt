import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui.referral

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.ReferralViewModel

@Composable
fun ReferralScreen(vm: ReferralViewModel = viewModel()) {
    val count by vm.referralCount.collectAsState()
    Column(modifier = Modifier.padding(16.dp)) {
        Text(\"Referral Count\", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        Text(\"Total Referrals: \\", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { vm.addReferral() }) {
            Text(\"Add Referral\")
        }
    }
}

