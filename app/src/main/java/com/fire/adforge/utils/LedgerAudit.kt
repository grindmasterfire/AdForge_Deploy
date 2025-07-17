import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.utils

data class LedgerEntry(val amount: Long, val reason: String, val timestamp: Long)

object LedgerAudit {

    fun calculateBalance(entries: List<LedgerEntry>): Long {
        return entries.sumOf { it.amount }
    }

    fun printAuditTrail(entries: List<LedgerEntry>) {
        println("🔍 Coin Ledger Audit:")
        entries.sortedBy { it.timestamp }.forEach {
            println("[\] \: \")
        }
    }
}

