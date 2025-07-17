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
import com.fire.adforge.backend.CrewManager
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

data class MemberEntry(val id: String, val role: String)

@Composable
fun CrewAdminPanel(crewId: String) {
    val db = FirebaseFirestore.getInstance()
    val scope = rememberCoroutineScope()
    var members by remember { mutableStateOf<List<MemberEntry>>(emptyList()) }

    LaunchedEffect(Unit) {
        val snap = db.collection("crews")
            .document(crewId)
            .collection("members")
            .get()
            .await()

        members = snap.documents.map {
            MemberEntry(it.id, it.getString("role") ?: "member")
        }
    }

    Column(modifier = Modifier.fillMaxWidth().padding(12.dp)) {
    var isPublic by remember { mutableStateOf(true) }
    val scope = rememberCoroutineScope()

    Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
        Text("Public Crew")
        Switch(
            checked = isPublic,
            onCheckedChange = {
                isPublic = it
                scope.launch {
                    CrewManager.togglePrivacy(crewId, isPublic)
                }
            },
            modifier = Modifier.padding(start = 8.dp)
        )
    }
    Spacer(modifier = Modifier.height(12.dp))
        Text("??? Admin Panel", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(12.dp))

        members.forEach { member ->
            Card(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
                Row(modifier = Modifier.padding(12.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                    Column {
                        Text(member.id)
                        Text("Role: ", style = MaterialTheme.typography.labelSmall)
                    }

                    Row {
                        Button(onClick = {
                            scope.launch {
                                CrewManager.promoteMember(crewId, member.id)
                            }
                        }) {
                            Text("Promote")
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Button(onClick = {
                            scope.launch {
                                CrewManager.kickMember(crewId, member.id)
                            }
                        }) {
                            Text("Kick")
                        }
                    }
                }
            }
        }
    }
}


