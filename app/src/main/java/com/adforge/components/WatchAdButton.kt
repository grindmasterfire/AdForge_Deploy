package com.adforge.components

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.adforge.breadloop.BreadloopSession

@Composable
fun WatchAdButton() {
    Button(onClick = {
        BreadloopSession().startSession()
    }) {
        Text("Watch Ad")
    }
}
