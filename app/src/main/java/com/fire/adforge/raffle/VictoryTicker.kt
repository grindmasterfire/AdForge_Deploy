import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.raffle

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration

data class RaffleWin(
    val username: String = "",
    val coins: Int = 0,
    val crewName: String? = null,
    val avatarUrl: String = "",
    val poolId: String = "",
    val timestamp: Long = 0L
)

object VictoryTicker {

    private val firestore = FirebaseFirestore.getInstance()
    private var listener: ListenerRegistration? = null
    val winFeed = mutableStateListOf<RaffleWin>()

    fun startListening() {
        stopListening() // Restart fresh
        listener = firestore.collection("raffle_winners")
            .orderBy("timestamp", com.google.firebase.firestore.Query.Direction.DESCENDING)
            .limit(10)
            .addSnapshotListener { snapshots, e ->
                if (e != null) {
                    Log.w("VictoryTicker", "listen:error", e)
                    return@addSnapshotListener
                }
                winFeed.clear()
                for (doc in snapshots!!) {
                    val win = doc.toObject(RaffleWin::class.java)
                    winFeed.add(win)
                }
            }
    }

    fun stopListening() {
        listener?.remove()
        listener = null
    }
}

