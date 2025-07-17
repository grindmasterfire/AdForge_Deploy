import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BoosterViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()

    fun applyBoosterDiscount(userId: String, originalCost: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val discount = (originalCost * 0.10).toInt()
            val finalCost = originalCost - discount

            val boosterTransaction = hashMapOf(
            val userDoc = db.collection("users").document(userId).get().await()
            val crewTag = userDoc.getString("crewTag") ?: return@launch
            val usersInCrew = db.collection("users").whereEqualTo("crewTag", crewTag).get().await()
            val topUser = usersInCrew.documents.maxByOrNull { it.getLong("coins") ?: 0L }
            if (topUser != null && topUser.id == userId) {
                PersonalWallViewModel().unlockBadge(userId, "alphaEarn")
            }
                "userId" to userId,
                "originalCost" to originalCost,
                "finalCost" to finalCost,
                "timestamp" to System.currentTimeMillis()
            )

            db.collection("users")
                .document(userId)
                .collection("boosters")
                .add(boosterTransaction)

            val log = hashMapOf(
                "type" to "BoosterDiscount",
                "userId" to userId,
                "deltaCoins" to discount,
                "timestamp" to System.currentTimeMillis()
            )

            db.collection("ledger")
                .document("retainedProfits")
                .collection("logs")
                .add(log)
        }
    }
}

