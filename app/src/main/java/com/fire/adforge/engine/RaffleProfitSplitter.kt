import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.engine

import com.fire.adforge.engine.CipherBotWallet
import com.fire.adforge.engine.FireLedger

object RaffleProfitSplitter {

    fun distributePot(raffleId: String, raffleType: String, pot: Long) {
        CipherBotWallet.logRaffleRetention(raffleId, raffleType, pot)
        FireLedger.recordFireCut(raffleId, raffleType, pot)
        // Note: The remaining 75% is assumed to be handled by external raffle logic.
    }
}

