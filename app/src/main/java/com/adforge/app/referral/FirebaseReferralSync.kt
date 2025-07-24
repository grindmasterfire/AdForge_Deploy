package com.adforge.app.referral

import com.google.firebase.firestore.FirebaseFirestore
import android.content.Context

class FirebaseReferralSync(private val context: Context) {

    private val firestore = FirebaseFirestore.getInstance()
    private val prefs = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

    fun uploadReferralChain(userId: String) {
        val chain = mapOf(
            "level_1" to prefs.getString("referral_level_1", "")!!,
            "level_2" to prefs.getString("referral_level_2", "")!!,
            "level_3" to prefs.getString("referral_level_3", "")!!,
            "level_4" to prefs.getString("referral_level_4", "")!!
        )

        firestore.collection("referrals")
            .document(userId)
            .set(chain)
            .addOnSuccessListener {
                println("Referral chain uploaded successfully.")
            }
            .addOnFailureListener { e ->
                println("Failed to upload referral chain: \")
            }
    }
}
