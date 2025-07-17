package com.fire.adforge.backend

import android.content.Context
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase
import com.google.firebase.analytics.ktx.analytics

object AnalyticsTracker {
    private lateinit var analytics: FirebaseAnalytics

    fun init(context: Context) {
        analytics = Firebase.analytics
    }

    fun logRaffleEntry(userId: String, raffleType: String) {
        analytics.logEvent("raffle_entry") {
            param("user_id", userId)
            param("raffle_type", raffleType)
        }
    }

    fun logOfferComplete(userId: String, offerId: String) {
        analytics.logEvent("offer_completed") {
            param("user_id", userId)
            param("offer_id", offerId)
        }
    }

    fun logScreenView(screenName: String) {
        analytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW) {
            param(FirebaseAnalytics.Param.SCREEN_NAME, screenName)
        }
    }
}
