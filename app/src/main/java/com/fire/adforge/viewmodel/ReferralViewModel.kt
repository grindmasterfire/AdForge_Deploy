import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ReferralViewModel : ViewModel() {
    private val _referralCount = MutableStateFlow(0)
    val referralCount: StateFlow<Int> = _referralCount

    fun addReferral() {
        _referralCount.value += 1
    }
}

