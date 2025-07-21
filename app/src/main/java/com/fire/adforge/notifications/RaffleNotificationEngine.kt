package com.fire.adforge.notifications

import android.content.Context
import android.widget.Toast

object RaffleNotificationEngine {
    fun notifyWin(context: Context, raffleId: String) {
        Toast.makeText(context, \" You won raffle \!\", Toast.LENGTH_LONG).show()
    }

    fun notifyLoss(context: Context, raffleId: String) {
        Toast.makeText(context, \" No win in raffle \. Try again!\", Toast.LENGTH_SHORT).show()
    }

    fun notifyCapReached(context: Context, raffleId: String) {
        Toast.makeText(context, \" Raffle \ reached ticket cap!\", Toast.LENGTH_SHORT).show()
    }

    fun notifyEntryConfirmed(context: Context, raffleId: String) {
        Toast.makeText(context, \" Entered raffle \ successfully\", Toast.LENGTH_SHORT).show()
    }
}
