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
import com.fire.adforge.data.BadgeSource
import com.fire.adforge.viewmodel.PersonalWallViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun PersonalWallScreen(userId: String = "testUser", vm: PersonalWallViewModel = viewModel()) {
    var crewTag by remember { mutableStateOf("...") }
    var clanId by remember { mutableStateOf("...") }
    var clanCount by remember { mutableStateOf("...") }
    var crewCount by remember { mutableStateOf("...") }
    var crewMultiplier by remember { mutableStateOf("...") }

    val unlocked by vm.unlockedBadges.collectAsState()
    val db = FirebaseFirestore.getInstance()

    LaunchedEffect(Unit) {
        vm.loadUnlocked(userId)

        db.collection("users").document(userId).get().addOnSuccessListener {
            crewTag = it.getString("crewTag") ?: "-"
            clanId = it.getString("clanId") ?: "-"

            if (clanId != "-") {
                db.collection("clans").document(clanId).get().addOnSuccessListener { clanSnap ->
                    clanCount = (clanSnap.getLong("memberCount") ?: 0).toString()
                }
            }

            if (crewTag != "-") {
                db.collection("users").whereEqualTo("crewTag", crewTag).get().addOnSuccessListener { result ->
                    val count = result.size()
                    crewCount = count.toString()
                    crewMultiplier = when {
                        count in 2..4 -> "1.02×"
                        count in 5..9 -> "1.05×"
                        count >= 10 -> "1.10×"
                        else -> "1.00×"
                    }
                }
            }
        }
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text("🧱 Personal Wall", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(12.dp))

        Text("Crew Tag: \", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))

        Text("Clan ID: \", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))

        Text("Clan Members: \", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))

        Text("Crew Members: \", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))

        Text("Crew Multiplier: \", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(24.dp))

        Text("Achievements:", style = MaterialTheme.typography.titleMedium)
        var expanded by remember { mutableStateOf(true) }
        Text("Achievements:", style = MaterialTheme.typography.titleMedium)
        Button(onClick = { expanded = !expanded }) {
            Text(if (expanded) "Hide" else "Show")
        }
        if (expanded) {
        var selectedTab by remember { mutableStateOf("All") }
        val tabs = listOf("All", "Milestones", "Social", "Raffle")

        TabRow(selectedTabIndex = tabs.indexOf(selectedTab)) {
            tabs.forEachIndexed { index, label ->
                Tab(
                    selected = selectedTab == label,
                    onClick = { selectedTab = label },
                    text = { Text(label) }
                )
            }
        }

        val filteredBadges = BadgeSource.allBadges.filter {
            when (selectedTab) {
                "Milestones" -> it.id in listOf("firstSpin", "fireProof")
                "Social"     -> it.id in listOf("crewMate", "clanFormed")
                "Raffle"     -> it.id in listOf("alphaEarn")
                else         -> true
            }
        }
        }
                }
            }
        }
    }
        Spacer(modifier = Modifier.height(32.dp))
        Text("Admin Panel: Grant Badge", style = MaterialTheme.typography.titleMedium)

        var selectedId by remember { mutableStateOf("firstSpin") }
        val all = listOf("firstSpin", "crewMate", "clanFormed", "fireProof", "alphaEarn")

        DropdownMenuBox(selectedId, all) { newId ->
            selectedId = newId
        }

        Button(onClick = { vm.unlockBadge(userId, selectedId) }) {
            Text("Grant Badge")
        }
}
        Spacer(modifier = Modifier.height(32.dp))
        Text("Admin Panel: Grant Badge", style = MaterialTheme.typography.titleMedium)

        var selectedId by remember { mutableStateOf("firstSpin") }
        val all = listOf("firstSpin", "crewMate", "clanFormed", "fireProof", "alphaEarn")

        DropdownMenuBox(selectedId, all) { newId ->
            selectedId = newId
        }

        Button(onClick = { vm.unlockBadge(userId, selectedId) }) {
            Text("Grant Badge")
        }

