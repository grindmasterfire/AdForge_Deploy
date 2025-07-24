package com.adforge.components

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

object LiveFeed {
    private val feed = mutableStateListOf<String>()

    fun post(message: String) {
        feed.add(0, message)
        if (feed.size > 10) feed.removeLast()
    }

    @Composable
    fun Display() {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(" Live Feed", style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.height(4.dp))
            for (msg in feed) {
                Text(" ")
            }
        }
    }
}
