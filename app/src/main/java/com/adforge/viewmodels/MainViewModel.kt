package com.adforge.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _screenState = MutableLiveData<String>()
    val screenState: LiveData<String> get() = _screenState

    init {
        _screenState.value = "home"
    }

    fun setScreen(screen: String) {
        _screenState.value = screen
    }
}
