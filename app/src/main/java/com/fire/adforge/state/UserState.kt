import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.state

object UserState {
    var currentUserId: String? = null
    var currentCrewId: String? = null
    var currentPoints: Int = 0

    fun reset() {
        currentUserId = null
        currentCrewId = null
        currentPoints = 0
    }

    fun isLoggedIn(): Boolean {
        return !currentUserId.isNullOrEmpty()
    }
}

