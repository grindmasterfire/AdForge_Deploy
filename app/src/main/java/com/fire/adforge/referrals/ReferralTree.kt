import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.referrals

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

object ReferralTree {

    private val db = FirebaseFirestore.getInstance()

    suspend fun getDownline(userId: String, depth: Int = 4): Map<Int, List<String>> {
        val tree = mutableMapOf<Int, List<String>>()
        var currentLevel = listOf(userId)

        for (tier in 1..depth) {
            val nextLevel = mutableListOf<String>()
            for (uid in currentLevel) {
                val result = db.collection("users").whereEqualTo("referrer", uid).get().await()
                val referrals = result.documents.mapNotNull { it.id }
                nextLevel.addAll(referrals)
            }
            if (nextLevel.isEmpty()) break
            tree[tier] = nextLevel
            currentLevel = nextLevel
        }

        return tree
    }
}

