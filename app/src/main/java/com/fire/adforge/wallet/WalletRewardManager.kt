package com.fire.adforge.wallet

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.Timestamp

object WalletRewardManager {
    private val db = FirebaseFirestore.getInstance()

    fun logReward(userId: String, amount: Int, source: String) {
        val log = hashMapOf(
            "userId" to userId,
            "amount" to amount,
            "source" to source,
            "timestamp" to Timestamp.now()
        )

        db.collection("wallet_rewards")
            .add(log)
            .addOnSuccessListener {
                Log.d("WalletRewardManager", "Logged wallet reward successfully")
            }
            .addOnFailureListener { e ->
                Log.e("WalletRewardManager", "Failed to log wallet reward", e)
            }
    }
}
