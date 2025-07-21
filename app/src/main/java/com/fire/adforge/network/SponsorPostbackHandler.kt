package com.fire.adforge.network

import android.util.Log
import java.net.URLDecoder

object SponsorPostbackHandler {
    fun receivePostback(url: String) {
        try {
            val decodedUrl = URLDecoder.decode(url, "UTF-8")
            val sponsor = extractParam(decodedUrl, "sponsor") ?: "unknown"
            val userId = extractParam(decodedUrl, "user_id") ?: return
            val reward = extractParam(decodedUrl, "reward")?.toIntOrNull() ?: 0
            Log.d("SponsorPostback", "Received postback: \ rewarded \ to \")
            com.fire.adforge.wallet.WalletRewardManager.rewardUserFromSponsor(reward, sponsor)
        } catch (e: Exception) {
            Log.e("SponsorPostback", "Postback error: \")
        }
    }

    private fun extractParam(url: String, key: String): String? {
        val regex = Regex("[?&]=([^&]+)")
        return regex.find(url)?.groupValues?.get(1)
    }
}
