package com.fire.adforge.model

data class Badge(
    val id: String,
    val label: String,
    val description: String,
    val unlocked: Boolean = false
)

object BadgeRules {

    fun getStarterBadges(): List<Badge> {
        return listOf(
            Badge("first_raffle", "🎯 First Raffle Entry", "Entered your first raffle"),
            Badge("offer_grinder", "💰 Offer Wall Grinder", "Completed 10 offers"),
            Badge("crew_leader", "🛡️ Crew Commander", "Created a crew and recruited a member"),
            Badge("streak_master", "🔥 Daily Streak", "Logged in 7 days straight")
        )
    }
}
