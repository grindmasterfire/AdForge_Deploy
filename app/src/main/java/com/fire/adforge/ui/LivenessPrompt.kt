import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import androidx.compose.material3.*
import androidx.compose.runtime.*

@Composable
fun LivenessPrompt(onAcknowledge: () -> Unit) {
    AlertDialog(
        onDismissRequest = {},
        title = { Text("Are you still watching?") },
        text = { Text("Tap below to stay active in the raffle.") },
        confirmButton = {
            Button(onClick = onAcknowledge) {
                Text("I'm here!")
            }
        }
    )
}

