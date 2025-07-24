package com.adforge.raffle

data class TicketEntry(
    val userId: String,
    val raffleType: RaffleType,
    val ticketCount: Int,
    val timestamp: Long = System.currentTimeMillis()
)

object TicketLedger {
    private val ledger = mutableListOf<TicketEntry>()

    fun logEntry(userId: String, type: RaffleType, count: Int) {
        ledger.add(TicketEntry(userId, type, count))
    }

    fun getEntries(type: RaffleType): List<TicketEntry> {
        return ledger.filter { it.raffleType == type }
    }

    fun getTotalTickets(type: RaffleType): Int {
        return getEntries(type).sumOf { it.ticketCount }
    }

    fun clearLedger(type: RaffleType) {
        ledger.removeAll { it.raffleType == type }
    }

    fun all(): List<TicketEntry> = ledger.toList()
}
