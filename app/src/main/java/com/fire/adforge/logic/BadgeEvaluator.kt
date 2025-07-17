package com.fire.adforge.logic

import com.fire.adforge.model.Badge
import com.fire.adforge.model.BadgeRules
import com.fire.adforge.backend.MetricsTracker
import kotlinx.coroutines.runBlocking

object BadgeEvaluator {

    fun evaluateAll(userId: String): List<Badge> = runBlocking {
        val stats = MetricsTracker.fetchMetrics(userId)

        val unlocked = mutableListOf<Badge>()

        BadgeRules.getStarterBadges().forEach { badge ->
            val match = when (badge.id) {
                "first_raffle" -> stats.totalRaffleWins > 0
                "offer_grinder" -> stats.totalOffersCompleted >= 10
                "crew_leader" -> stats.totalInvitesSent >= 1
                "streak_master" -> false // TODO: Add streak detection
                else -> false
            }
            if (match) unlocked.add(badge.copy(unlocked = true))
        }

        unlocked
    }
}
