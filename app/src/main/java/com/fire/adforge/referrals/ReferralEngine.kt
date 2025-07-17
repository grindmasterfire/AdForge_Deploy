import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.referrals

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

object ReferralEngine {

    private val db = FirebaseFirestore.getInstance()
    private val tierBonuses = listOf(0.10, 0.05, 0.03, 0.01)

    suspend fun distributeReferralEarnings(userId: String, earnedCoins: Int) {
        try {
            val refDoc = db.collection("referral_links").document(userId).get().await()
            val upline = refDoc.get("upline") as? List<String> ?: return

            for (i in 0 until minOf(upline.size, 4)) {
                val referrerId = upline[i]
                val bonus = (earnedCoins * tierBonuses[i]).toInt()
                injectBonus(referrerId, bonus, "referral_tier_")
            }

        } catch (e: Exception) {
            Log.e("ReferralEngine", "Referral payout failed", e)
        }
    }

    private suspend fun injectBonus(referrerId: String, coins: Int, source: String) {
        try {
            val walletRef = db.collection("wallets").document(referrerId)
            db.runTransaction { tx ->
                val snapshot = tx.get(walletRef)
                val current = snapshot.getLong("coins") ?: 0
                tx.update(walletRef, "coins", current + coins)
                tx.update(walletRef, "lastSource", source)
            }.await()
        } catch (e: Exception) {
            Log.e("ReferralEngine", "Bonus injection failed", e)
        }
    }
}

