package com.fire.adforge.ui

import androidx.compose.foundation.layout.*`nimport com.fire.adforge.backend.CrewManager
import androidx.compose.foundation.text.BasicTextField`nimport com.fire.adforge.backend.CrewManager
import androidx.compose.material3.*`nimport com.fire.adforge.backend.CrewManager
import androidx.compose.runtime.*`nimport com.fire.adforge.backend.CrewManager
import androidx.compose.ui.Modifier`nimport com.fire.adforge.backend.CrewManager
import androidx.compose.ui.unit.dp`nimport com.fire.adforge.backend.CrewManager
import com.google.firebase.auth.FirebaseAuth`nimport com.fire.adforge.backend.CrewManager
import com.google.firebase.firestore.FirebaseFirestore`nimport com.fire.adforge.backend.CrewManager

@Composable
fun CrewJoinScreen() {
    var crewName by remember { mutableStateOf("") }
    val auth = FirebaseAuth.getInstance()
    val db = FirebaseFirestore.getInstance()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Join or Create a Crew", style = MaterialTheme.typography.headlineMedium)

        BasicTextField(
            value = crewName,
            onValueChange = { crewName = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        )

        Button(onClick = {
            val uid = auth.currentUser?.uid ?: return@Button
            db.collection("users").document(uid).update("crewName", crewName)
        }) {
            Text("Join Crew")
        }
    }
}
