import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.data

object BadgeSource {
    val allBadges = listOf(
        Badge("firstSpin", "First Spin", "Completed your first autoplay session!", "\uD83C\uDFB2"),
        Badge("crewMate", "Crew Initiate", "Joined a crew", "\uD83D\uDC65"),
        Badge("clanFormed", "Clan Founder", "Formed a clan with 5 crews", "\uD83C\uDFC6"),
        Badge("fireProof", "Fireproof", "Logged in 21 days in a row", "\uD83D\uDD25"),
        Badge("alphaEarn", "Alpha Earner", "Top 1% of earners in your crew", "\uD83C\uDF1F")
    )
}

