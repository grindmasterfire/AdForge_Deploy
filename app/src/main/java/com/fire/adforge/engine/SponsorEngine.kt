package com.fire.adforge.engine

enum class SponsorCategory {
    AUTOPLAY, OFFERWALL, SURVEY, TRIAL, CASHBACK, FOCUSGROUP, EMAIL, GAME
}

data class SponsorPartner(val name: String, val category: SponsorCategory)

object SponsorEngine {
    val sponsors = listOf(
        SponsorPartner("Unity Ads", SponsorCategory.AUTOPLAY),
        SponsorPartner("ExoClick", SponsorCategory.AUTOPLAY),
        SponsorPartner("StartApp", SponsorCategory.AUTOPLAY),
        SponsorPartner("Vungle", SponsorCategory.AUTOPLAY),
        SponsorPartner("AdColony", SponsorCategory.AUTOPLAY),
        SponsorPartner("Mintegral", SponsorCategory.AUTOPLAY),
        SponsorPartner("Chartboost Mediation", SponsorCategory.AUTOPLAY),
        SponsorPartner("AppLovin MAX", SponsorCategory.AUTOPLAY),
        SponsorPartner("Bidease", SponsorCategory.AUTOPLAY),
        SponsorPartner("AdGem", SponsorCategory.OFFERWALL),
        SponsorPartner("AdGate Media", SponsorCategory.OFFERWALL),
        SponsorPartner("OfferToro", SponsorCategory.OFFERWALL),
        SponsorPartner("Ayet Studios", SponsorCategory.OFFERWALL),
        SponsorPartner("Lootably", SponsorCategory.OFFERWALL),
        SponsorPartner("CPX Research", SponsorCategory.SURVEY),
        SponsorPartner("Pollfish", SponsorCategory.SURVEY),
        SponsorPartner("Bitlabs", SponsorCategory.SURVEY),
        SponsorPartner("RevU", SponsorCategory.TRIAL),
        SponsorPartner("RevenueUniverse", SponsorCategory.TRIAL),
        SponsorPartner("Peanut Labs", SponsorCategory.TRIAL),
        SponsorPartner("Karma Wallet", SponsorCategory.CASHBACK),
        SponsorPartner("Rakuten", SponsorCategory.CASHBACK),
        SponsorPartner("Swagbucks", SponsorCategory.CASHBACK),
        SponsorPartner("UserInterviews", SponsorCategory.FOCUSGROUP),
        SponsorPartner("Respondent.io", SponsorCategory.FOCUSGROUP),
        SponsorPartner("InboxDollars", SponsorCategory.EMAIL),
        SponsorPartner("Yuno", SponsorCategory.EMAIL),
        SponsorPartner("TGM Panel", SponsorCategory.EMAIL)
    )
}
