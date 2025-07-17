import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class OfferwallViewModel : ViewModel() {
    private val _offers = MutableStateFlow<List<String>>(emptyList())
    val offers: StateFlow<List<String>> = _offers

    fun loadOffers() {
        // Placeholder for offerwall load logic
        _offers.value = listOf(\"Offer 1\", \"Offer 2\", \"Offer 3\")
    }
}

