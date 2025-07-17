import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.models

import com.fire.adforge.data.User

data class MilestoneBooster(
    val id: String,
    val label: String,
    val price: Int, // in coins
    val coinEligible: Boolean = true,
    val discountRate: Double? = 0.05,
    val linkedMilestoneId: String
) {
    fun unlockFor(user: User) {
        println("[Milestone] Booster '\' activated for \")
        // Future: Firebase patch or milestone unlock backend logic
    }
}

