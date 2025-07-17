import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class RewardViewModel : ViewModel() {
    private val _rewards = MutableLiveData<List<String>>(emptyList())
    val rewards: LiveData<List<String>> = _rewards

    fun loadRewards() {
        // ?? Replace with real DB/API later
        _rewards.value = listOf(
            "?? +10 coins - Autoplay",
            "?? +15 coins - Raffle Win",
            "?? +5 coins - Survey Complete"
        )
    }
}

