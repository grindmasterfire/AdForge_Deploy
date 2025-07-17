import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.database.FirebaseDatabase

class LegalViewModel : ViewModel() {
    private val db = FirebaseDatabase.getInstance()

    fun acceptLegal(userId: String) {
        db.getReference("users/\/acceptedLegal").setValue(true)
    }
}

