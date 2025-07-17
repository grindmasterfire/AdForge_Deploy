import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch

@Composable
fun QAHarnessScreen() {
    val db = FirebaseFirestore.getInstance()
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("🧪 QA Harness", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = {
            scope.launch {
                db.collection("raffles").add(
                    mapOf(
                        "raffleId" to "test_qa_raffle",
                        "type" to "daily",
                        "scope" to "global",
                        "created" to com.google.firebase.Timestamp.now(),
                        "endsAt" to com.google.firebase.Timestamp.now()
                    )
                )
            }
        }) {
            Text("Create Test Raffle")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            scope.launch {
                val snap = db.collection("users")
                    .document("test_user")
                    .collection("referrals")
                    .get()
                Log.d("QA", "Referrals: ")
            }
        }) {
            Text("Load Referral Tree (test_user)")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            scope.launch {
                val crewSnap = db.collection("crews").get()
                Log.d("QA", "Crews Loaded: ")
            }
        }) {
            Text("Check Crew Data")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            FirebaseCrashlytics.getInstance().log("Force crash test triggered")
            throw RuntimeException("🔥 QA Crash Test Triggered")
        }) {
            Text("Force Crash")
        }
    }
}

