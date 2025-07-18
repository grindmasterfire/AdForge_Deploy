package com.fire.adforge.util

import com.fire.adforge.model.CoinLedger
import com.google.firebase.firestore.FirebaseFirestore

object CoinLedgerLogger {
    private val db = FirebaseFirestore.getInstance()
    private val logRef = db.collection(\"coin_ledger\")

    fun log(entry: CoinLedger) {
        logRef.add(entry)
    }
}
