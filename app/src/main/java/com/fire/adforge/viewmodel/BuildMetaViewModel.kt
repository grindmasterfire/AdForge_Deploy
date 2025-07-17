import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.database.FirebaseDatabase
import com.fire.adforge.FIRE_OWNER

class BuildMetaViewModel : ViewModel() {
    private val db = FirebaseDatabase.getInstance()

    init {
        db.getReference("buildMeta/fireOwner").setValue(FIRE_OWNER)
    }
}

