package com.fire.adforge.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import java.io.InputStream

data class SponsorPartner(
    val name: String,
    val type: String,
    val status: String
)

class SponsorFeedViewModel : ViewModel() {
    suspend fun loadSponsors(context: Context): List<SponsorPartner> = withContext(Dispatchers.IO) {
        val jsonStr = context.assets.open("affiliate_partners.json").bufferedReader().use { it.readText() }
        val jsonArray = JSONArray(jsonStr)
        List(jsonArray.length()) {
            val obj = jsonArray.getJSONObject(it)
            SponsorPartner(
                name = obj.getString("name"),
                type = obj.optString("type", "unknown"),
                status = obj.optString("status", "pending")
            )
        }
    }
}
