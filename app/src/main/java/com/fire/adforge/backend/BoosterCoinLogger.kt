package com.fire.adforge.backend

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

object BoosterCoinLogger {

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    fun logCoinSpend(amount: Int, reason: String = "booster_purchase") {
        val uid = auth.currentUser?.uid ?: return
        val logData = mapOf(
            "amount" to amount,
            "reason" to reason,
            "timestamp" to System.currentTimeMillis()
        )
        db.collection("users")
          .document(uid)
          .collection("coin_log")
          .add(logData)
    }
}
