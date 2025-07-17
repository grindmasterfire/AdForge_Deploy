import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.fire.adforge.model.UserWallMeta
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.firestore.FieldValue
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class WallViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()
    private val userId = Firebase.auth.currentUser?.uid ?: "unknown"

    private val _userWallData = MutableStateFlow(UserWallMeta())
    val userWallData: StateFlow<UserWallMeta> = _userWallData

    init {
        db.collection("userWalls").document(userId).addSnapshotListener { snapshot, _ ->
            snapshot?.toObject(UserWallMeta::class.java)?.let {
                _userWallData.value = it
            }
        }
    }

    fun toggleGrindStatus() {
        val current = _userWallData.value
// ⚠️ invalid chained assignment
        db.collection("userWalls").document(userId).set(updated)
    }
}





