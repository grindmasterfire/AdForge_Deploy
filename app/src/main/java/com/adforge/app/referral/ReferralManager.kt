package com.adforge.app.referral

import android.content.Context
import android.widget.Toast

class ReferralManager(private val context: Context) {

    private val prefs = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

    fun getReferralChain(): List<String> {
        val level1 = prefs.getString("referral_level_1", "") ?: ""
        val level2 = prefs.getString("referral_level_2", "") ?: ""
        val level3 = prefs.getString("referral_level_3", "") ?: ""
        val level4 = prefs.getString("referral_level_4", "") ?: ""
        return listOf(level1, level2, level3, level4).filter { it.isNotEmpty() }
    }

    fun applyReferralRewards(amountEarned: Int) {
        val chain = getReferralChain()

        val payouts = listOf(0.10, 0.05, 0.03, 0.01)
        val messages = mutableListOf<String>()

        for ((i, refId) in chain.withIndex()) {
            val percent = payouts.getOrNull(i) ?: 0.0
            val reward = (amountEarned * percent).toInt()
            messages.add("Referral L\: ID \ earns \ coins")
        }

        Toast.makeText(context, messages.joinToString("\n"), Toast.LENGTH_LONG).show()
    }
}
