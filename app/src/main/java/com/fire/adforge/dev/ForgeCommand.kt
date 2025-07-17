import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.dev

import com.fire.adforge.economy.CoinManager
import com.fire.adforge.social.CrewManager

object ForgeCommand {

    fun resetCoins() {
        CoinManager.reset()
    }

    fun testAddCoins(amount: Int = 100) {
        CoinManager.addCoins(amount)
    }

    fun assignCrewMultiplier(crewId: String, multiplier: Double) {
        CrewManager.assignMultiplier(crewId, multiplier)
    }

    fun wipeCrewData(crewId: String) {
        // Placeholder — use with caution
    }
}

