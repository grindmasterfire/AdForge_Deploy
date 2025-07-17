import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.ui.Modifier

@Composable
fun FounderBadge(founderRank: Int?) {
    if (founderRank == null || founderRank <= 0) return

    Text(
        text = "🌟 Founder #",
        modifier = Modifier,
    )
}

