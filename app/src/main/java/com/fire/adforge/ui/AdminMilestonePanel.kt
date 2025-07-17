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

@Composable
fun AdminMilestonePanel(offerId: String) {`r`n    var authPassed by remember { mutableStateOf(false) }`r`n    var input by remember { mutableStateOf("") }`r`n    if (!authPassed) { Column(Modifier.padding(20.dp)) { OutlinedTextField(value = input, onValueChange = { input = it }, label = { Text("Enter Admin Key") }); Spacer(Modifier.height(8.dp)); Button(onClick = { if (input == "forge123") authPassed = true }) { Text("Unlock") } } return }
    val db = FirebaseFirestore.getInstance()
    var goal by remember { mutableStateOf("") }
    var cost by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(20.dp)) {
        Text("Edit Milestone Config", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(12.dp))

        OutlinedTextField(value = goal, onValueChange = { goal = it }, label = { Text("Milestone Goal") })
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(value = cost, onValueChange = { cost = it }, label = { Text("Boost Cost") })

        Spacer(Modifier.height(12.dp))
        Button(onClick = {
            db.collection("milestones").document(offerId).update(
                mapOf(
                    "goal" to goal.toIntOrNull(),
                    "boostCost" to cost.toIntOrNull()
                )
            )
        }) {
            Text("Save Config")
        }
    }
}

