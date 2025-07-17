import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.database.FirebaseDatabase

class UserSettingsViewModel : ViewModel() {
    private val db = FirebaseDatabase.getInstance()

    fun setAgeFlag(userId: String, isOver18: Boolean) {
        db.getReference("users//isOver18").setValue(isOver18)
    }

    fun checkAgeFlag(userId: String, onResult: (Boolean) -> Unit) {
        db.getReference("users//isOver18").get().addOnSuccessListener { snapshot ->
            val flag = snapshot.getValue(Boolean::class.java) ?: false
            onResult(flag)
        }
    }
}


