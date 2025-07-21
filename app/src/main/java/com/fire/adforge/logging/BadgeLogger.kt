package com.fire.adforge.logging

import android.util.Log

object BadgeLogger {
    fun logGrant(userId: String, badgeId: String) {
        Log.d("BadgeLogger", "Granted badge '' to user ''")
    }
}
