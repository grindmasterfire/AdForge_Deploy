package com.fire.adforge.raffle

object RaffleEntryRouter {
    fun routeToEngine(type: RaffleType): String {
        return when (type) {
            RaffleType.DAILY_CAPPED,
            RaffleType.DAILY_UNCAPPED -> "DailyRaffleLimiter"
            RaffleType.SEVEN_DAY -> SevenDayRaffle
            RaffleType.JACKPOT_21_DAY -> "JackpotLogic"
            RaffleType.TIERED_21_DAY -> "TieredRaffleSplitter"
            RaffleType.PARTICIPATION_21_DAY -> "ConstellationPrizeDistributor"
            RaffleType.CREW_PRIVATE -> "CrewPrivateRaffleManager"
            RaffleType.CREW_PUBLIC -> "CrewPublicRaffleContest"
            RaffleType.BREADLOOP_SESSION -> "BreadloopRaffleSession"
        }
    }
}
