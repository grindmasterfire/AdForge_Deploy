import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SessionManagementViewModel : ViewModel() {
    private val _isUserActive = MutableStateFlow(true)
    val isUserActive: StateFlow<Boolean> = _isUserActive

    fun setUserActive(active: Boolean) {
        _isUserActive.value = active
    }
}

