
fun recordTicketEntry(userId: String, coinsUsed: Int, sponsorSource: String) {
    raffleEntries.add(
        RaffleEntry(
            userId = userId,
            ticketValue = coinsUsed,
            source = sponsorSource,
            timestamp = System.currentTimeMillis()
        )
    )
}
