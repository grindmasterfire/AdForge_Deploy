import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

@Composable
fun AdForgeTheme(content: @Composable () -> Unit) {
    val colorScheme = darkColorScheme(
        primary = Purple500,
        onPrimary = White,
        secondary = Teal200,
        onSecondary = Black
    )

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}

