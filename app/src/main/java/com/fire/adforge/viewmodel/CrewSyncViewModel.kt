import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CrewSyncViewModel : ViewModel() {

    var sessionTriggers: Int = 0
        private set

    fun triggerCrewActivityEvent() {
        viewModelScope.launch {
            sessionTriggers++
            delay(100)
        }
    }

    fun resetSessionTriggers() {
        sessionTriggers = 0
    }
}

