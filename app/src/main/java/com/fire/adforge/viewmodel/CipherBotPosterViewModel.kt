package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fire.adforge.engine.MemeForge
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CipherBotPosterViewModel : ViewModel() {
    val postStatus = MutableStateFlow("")

    fun postNow() {
        viewModelScope.launch {
            try {
                MemeForge.postToWall()
                postStatus.value = " Meme posted to CipherWall!"
            } catch (e: Exception) {
                postStatus.value = " Failed to post."
            }
        }
    }
}
