package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fire.adforge.engine.WallPostReactEngine
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CrewWallReactViewModel : ViewModel() {
    val emoji = MutableStateFlow("")
    val selectedBadge = MutableStateFlow("Rally Leader")
    val postId = MutableStateFlow("")
    val crewId = MutableStateFlow("")
    val status = MutableStateFlow("")
    private val userId = "demoUser"

    fun react() {
        viewModelScope.launch {
            try {
                WallPostReactEngine.reactWithBadge(
                    postId.value,
                    crewId.value,
                    userId,
                    selectedBadge.value,
                    emoji.value
                )
                status.value = "Reacted with !"
            } catch (e: Exception) {
                status.value = "Failed to react."
            }
        }
    }
}
