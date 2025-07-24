package com.adforge.app

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

enum class BreadloopState {
    IDLE, WATCHING, VERIFYING, REWARDED
}

class MainViewModel : ViewModel() {

    private lateinit var prefs: SharedPreferences

    private val _breadloopState = MutableLiveData(BreadloopState.IDLE)
    val breadloopState: LiveData<BreadloopState> = _breadloopState

    private val _rewardCoinCount = MutableLiveData(0)
    val rewardCoinCount: LiveData<Int> = _rewardCoinCount

    private val _raffleTicketCount = MutableLiveData(0)
    val raffleTicketCount: LiveData<Int> = _raffleTicketCount

    private val _raffleTriggered = MutableLiveData(false)
    val raffleTriggered: LiveData<Boolean> = _raffleTriggered

    private val _userReferralCode = MutableLiveData("")
    val userReferralCode: LiveData<String> = _userReferralCode

    private val _crewCode = MutableLiveData("")
    val crewCode: LiveData<String> = _crewCode

    private val _crewSize = MutableLiveData(0)
    val crewSize: LiveData<Int> = _crewSize

    private val _crewMultiplier = MutableLiveData(1.0)
    val crewMultiplier: LiveData<Double> = _crewMultiplier

    fun initStorage(context: Context) {
        prefs = context.getSharedPreferences("AdForgePrefs", Context.MODE_PRIVATE)
        _rewardCoinCount.value = prefs.getInt("rewardCoins", 0)
        _raffleTicketCount.value = prefs.getInt("raffleTickets", 0)
        _userReferralCode.value = prefs.getString("referralCode", "") ?: ""
        _crewCode.value = prefs.getString("crewCode", "") ?: ""
        _crewSize.value = prefs.getInt("crewSize", 0)
        _crewMultiplier.value = prefs.getFloat("crewMultiplier", 1.0f).toDouble()
    }

    init {
        viewModelScope.launch {
            delay(2000)
            _breadloopState.value = BreadloopState.WATCHING
            delay(3000)
            _breadloopState.value = BreadloopState.VERIFYING
            delay(2000)
            _breadloopState.value = BreadloopState.REWARDED

            addRewardCoin()
            triggerRaffle()
            simulateCrewJoin()
        }
    }

    private fun addRewardCoin() {
        val newCoins = (_rewardCoinCount.value ?: 0) + 1
        _rewardCoinCount.value = newCoins
        prefs.edit().putInt("rewardCoins", newCoins).apply()
    }

    fun triggerRaffle() {
        _raffleTriggered.value = true

        val newTickets = (_raffleTicketCount.value ?: 0) + 1
        _raffleTicketCount.value = newTickets
        prefs.edit().putInt("raffleTickets", newTickets).apply()
    }

    fun setReferralCode(code: String) {
        _userReferralCode.value = code
        prefs.edit().putString("referralCode", code).apply()
    }

    fun setCrewCode(code: String) {
        _crewCode.value = code
        prefs.edit().putString("crewCode", code).apply()
    }

    fun simulateCrewJoin() {
        val newSize = (_crewSize.value ?: 0) + 1
        _crewSize.value = newSize
        prefs.edit().putInt("crewSize", newSize).apply()

        val multiplier = 1.0 + (newSize * 0.05)
        _crewMultiplier.value = multiplier
        prefs.edit().putFloat("crewMultiplier", multiplier.toFloat()).apply()
    }
}
