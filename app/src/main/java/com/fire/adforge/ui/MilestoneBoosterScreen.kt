package com.fire.adforge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.MilestoneViewModel
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun MilestoneBoosterScreen(vm: MilestoneViewModel = viewModel()) {
    val offers = vm.boostableOffers.collectAsState()
    val boosts = vm.userBoosts.collectAsState()
    val coinBalance = vm.coinBalance.collectAsState()

    Column(Modifier.padding(16.dp)) {
        Text("Milestone Boosters", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(12.dp))

        offers.value.forEach { offer ->
            val discount = if (offer.tier == "premium") 0.10 else 0.05
            val cost = (offer.milestoneCost * (1 - discount)).toInt()
            val boosted = boosts.value.containsKey(offer.id)
            val ts = boosts.value[offer.id]

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Column(Modifier.padding(12.dp)) {
                    Text(offer.title, style = MaterialTheme.typography.titleMedium)

                    if (boosted && ts != null) {
                        val date = SimpleDateFormat("MMM dd, yyyy").format(Date(ts))
                        Text("? Boosted on ", style = MaterialTheme.typography.labelSmall)
                    }

                    Text("Original:  | Discounted:  coins")
                    Spacer(Modifier.height(6.dp))

                    Button(
                        onClick = { vm.boostMilestone(offer.id, cost) },
                        enabled = !boosted && coinBalance.value >= cost
                    ) {
                        val\ showConfirmationDialog\ =\ remember\ \{\ mutableStateOf\(false\)\ }\n\nif\ \(showConfirmationDialog\.value\)\ \{\n\ \ \ \ AlertDialog\(\n\ \ \ \ \ \ \ \ onDismissRequest\ =\ \{\ showConfirmationDialog\.value\ =\ false\ },\n\ \ \ \ \ \ \ \ title\ =\ \{\ Text\("Confirm\ Boost"\)\ },\n\ \ \ \ \ \ \ \ text\ =\ \{\ Text\("This\ action\ is\ final\ and\ non-refundable\.\ Do\ you\ want\ to\ proceed\?"\)\ },\n\ \ \ \ \ \ \ \ confirmButton\ =\ \{\n\ \ \ \ \ \ \ \ \ \ \ \ Button\(\n\ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ onClick\ =\ \{\n\ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ vm\.boostMilestone\(offer\.id,\ cost\)\n\ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ showConfirmationDialog\.value\ =\ false\n\ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ }\n\ \ \ \ \ \ \ \ \ \ \ \ \)\ \{\n\ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ Text\("Yes"\)\n\ \ \ \ \ \ \ \ \ \ \ \ }\n\ \ \ \ \ \ \ \ },\n\ \ \ \ \ \ \ \ dismissButton\ =\ \{\n\ \ \ \ \ \ \ \ \ \ \ \ Button\(\n\ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ onClick\ =\ \{\ showConfirmationDialog\.value\ =\ false\ }\n\ \ \ \ \ \ \ \ \ \ \ \ \)\ \{\n\ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ Text\("Cancel"\)\n\ \ \ \ \ \ \ \ \ \ \ \ }\n\ \ \ \ \ \ \ \ }\n\ \ \ \ \)\n}
                    }
                }
            }
        }
    }
}
