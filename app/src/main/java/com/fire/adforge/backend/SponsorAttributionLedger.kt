package com.fire.adforge.backend

import com.fire.adforge.engine.SponsorCategory

data class SponsorLogEntry(
    val userId: String,
    val sponsor: String,
    val category: SponsorCategory,
    val coinsEarned: Int,
    val timestamp: Long = System.currentTimeMillis()
)

object SponsorAttributionLedger {
    private val ledger = mutableListOf<SponsorLogEntry>()
    fun log(entry: SponsorLogEntry) = ledger.add(entry)
    fun getAll(): List<SponsorLogEntry> = ledger.toList()
}
