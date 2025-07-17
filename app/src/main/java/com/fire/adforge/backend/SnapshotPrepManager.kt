package com.fire.adforge.backend

import java.text.SimpleDateFormat
import java.util.*

object SnapshotPrepManager {
    private val launchDate = SimpleDateFormat("yyyy-MM-dd").parse("2025-07-31")

    fun daysUntilLaunch(): Int {
        val today = Calendar.getInstance().time
        val diff = launchDate.time - today.time
        return (diff / (1000 * 60 * 60 * 24)).toInt()
    }

    fun countdownLabel(): String {
        val days = daysUntilLaunch()
        return if (days > 0) {
            "⏳  days to go until global ignition."
        } else {
            "🚀 AdForge is LIVE. Strike the Play Store."
        }
    }
}
