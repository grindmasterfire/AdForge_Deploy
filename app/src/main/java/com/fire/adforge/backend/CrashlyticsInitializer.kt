package com.fire.adforge.backend

import android.util.Log
import com.google.firebase.crashlytics.FirebaseCrashlytics

object CrashlyticsInitializer {
    private val crashlytics = FirebaseCrashlytics.getInstance()

    fun reportError(message: String, throwable: Throwable? = null) {
        crashlytics.log(message)
        throwable?.let { crashlytics.recordException(it) }
    }

    fun setUserId(userId: String) {
        crashlytics.setUserId(userId)
    }

    fun enableLogging(enabled: Boolean) {
        crashlytics.setCrashlyticsCollectionEnabled(enabled)
    }
}
