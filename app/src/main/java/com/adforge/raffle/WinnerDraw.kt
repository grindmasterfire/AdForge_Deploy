package com.adforge.raffle

object WinnerDraw {

    fun drawWinners(type: RaffleType): List<String> {
        val entries = TicketLedger.getEntries(type)
        if (entries.isEmpty()) return emptyList()

        return when (type) {
            RaffleType.WINNER_TAKES_ALL -> {
val pool = mutableListOf<String>()
entries.forEach { entry ->
    repeat(entry.ticketCount) {
        pool.add(entry.userId)
    }
val pool = mutableListOf<String>()
entries.forEach { entry ->
    repeat(entry.ticketCount) {
        pool.add(entry.userId)
    }
}
pool.shuffle()
                listOf(pool.random())
            }

            RaffleType.TIERED_PLUS_40_SPLIT -> {
                val pool = entries.flatMap { List(it.ticketCount) { it.userId } }.shuffled()
                val distinct = pool.distinct()
                val top3 = distinct.take(3)
                val rest = distinct.drop(3).take((distinct.size * 0.4).toInt())
                top3 + rest
            }

            RaffleType.SIXTY_PERCENT_CONSOLATION -> {
                val allIds = entries.map { it.userId }.distinct()
                allIds.shuffled().take((allIds.size * 0.6).toInt())
            }
        }
    }
}
