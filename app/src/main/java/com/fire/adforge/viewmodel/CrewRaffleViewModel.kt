import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CrewRaffleViewModel : ViewModel() {
    private val _crewTicketMap = MutableStateFlow(mapOf<String, Int>())
    val crewTicketMap: StateFlow<Map<String, Int>> = _crewTicketMap

    private val _coinWeightMap = MutableStateFlow(mapOf<String, Int>())
    val coinWeightMap: StateFlow<Map<String, Int>> = _coinWeightMap

    fun syncCrewStatus() {
        _crewTicketMap.value = mapOf(
            "Crew Phoenix" to 31,
            "Crew Titan" to 57,
            "Crew Nova" to 14
        )

        _coinWeightMap.value = mapOf(
            "Crew Phoenix" to 780,
            "Crew Titan" to 2150,
            "Crew Nova" to 420
        )
    }
}

    fun buyTickets(userId: String, tickets: Int) {
        // TODO: Implement coin deduction logic here
        enterRaffle(userId, tickets)
    }




