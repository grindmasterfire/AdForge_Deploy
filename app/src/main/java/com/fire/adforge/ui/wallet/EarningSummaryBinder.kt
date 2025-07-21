package com.fire.adforge.ui.wallet

import com.fire.adforge.backend.SponsorAttributionLedger
import com.fire.adforge.engine.SponsorEngine

object EarningSummaryBinder {

    data class SummaryItem(
        val category: SponsorEngine.SponsorCategory,
        val totalCoins: Int
    )

    fun summarize(userId: String): List<SummaryItem> {
        return SponsorEngine.SponsorCategory.values().map { category ->
            val coins = SponsorAttributionLedger.getAll()
                .filter { it.userId == userId && it.category == category }
                .sumOf { it.coinsEarned }
            SummaryItem(category, coins)
        }.filter { it.totalCoins > 0 }
    }
}
