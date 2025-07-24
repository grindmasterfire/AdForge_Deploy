package com.adforge.economy

object CoinWallet {
    private val balances = mutableMapOf<String, Int>()

    fun getBalance(userId: String): Int {
        return balances[userId] ?: 0
    }

    fun addCoins(userId: String, amount: Int) {
        balances[userId] = getBalance(userId) + amount
    }

    fun spendCoins(userId: String, amount: Int): Boolean {
        val current = getBalance(userId)
        return if (current >= amount) {
            balances[userId] = current - amount
            true
        } else {
            false
        }
    }

    fun setBalance(userId: String, amount: Int) {
        balances[userId] = amount
    }

    fun all(): Map<String, Int> = balances.toMap()
}
