package com.fire.adforge.engine

object AutoplayShuffler {
    private val pool = SponsorEngine.sponsors.filter { it.category == SponsorCategory.AUTOPLAY }.shuffled()
    private var index = 0
    fun next(): SponsorPartner {
        val sponsor = pool[index % pool.size]
        index++
        return sponsor
    }
}
