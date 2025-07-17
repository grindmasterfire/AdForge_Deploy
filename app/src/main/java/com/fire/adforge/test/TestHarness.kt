package com.fire.adforge.test

import android.util.Log
import com.fire.adforge.backend.MetricsTracker
import com.fire.adforge.backend.CipherUplink
import com.fire.adforge.backend.CrashlyticsInitializer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object TestHarness {

    fun runAll(userId: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                testMetrics(userId)
                testCipherLog(userId)
                testCrashlytics(userId)
            } catch (e: Exception) {
                Log.e("TestHarness", "Failed: \")
            }
        }
    }

    private suspend fun testMetrics(userId: String) {
        MetricsTracker.updateMetric(userId, "totalOffersCompleted", 1)
        MetricsTracker.updateMetric(userId, "totalCoinsEarned", 100)
        Log.i("TestHarness", "✅ Metrics updated")
    }

    private suspend fun testCipherLog(userId: String) {
        CipherUplink.logEvent(userId, "qa", "Test cipher log event.")
        Log.i("TestHarness", "✅ Cipher log submitted")
    }

    private fun testCrashlytics(userId: String) {
        CrashlyticsInitializer.setUserId(userId)
        CrashlyticsInitializer.reportError("Test QA crash", RuntimeException("TestException"))
        Log.i("TestHarness", "✅ Crashlytics test sent")
    }
}
