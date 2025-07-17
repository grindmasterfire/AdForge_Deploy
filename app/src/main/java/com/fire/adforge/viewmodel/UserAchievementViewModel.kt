import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserAchievementViewModel : ViewModel() {
    private val _achievements = MutableStateFlow<List<String>>(emptyList())
    val achievements: StateFlow<List<String>> = _achievements

    fun unlockAchievement(achievement: String) {
        if (!_achievements.value.contains(achievement)) {
            _achievements.value = _achievements.value + achievement
        }
    }
}

