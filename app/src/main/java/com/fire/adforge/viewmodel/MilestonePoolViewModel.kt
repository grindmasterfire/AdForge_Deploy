import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MilestonePoolViewModel : ViewModel() {
    private val _pool = MutableStateFlow(0)
    val pool: StateFlow<Int> = _pool

    private val db = FirebaseFirestore.getInstance()

    fun observePool(offerId: String) {
        viewModelScope.launch {
            db.collection("milestones")
                .document(offerId)
                .addSnapshotListener { snapshot, _ ->
                    val coins = snapshot?.getLong("boosts")?.toInt() ?: 0
                    _pool.value = coins
                }
        }
    }
}

