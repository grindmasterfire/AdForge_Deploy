import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.*
import com.fire.adforge.model.RaffleClaim

class ClaimReviewViewModel : ViewModel() {
    private val _claim = MutableLiveData<RaffleClaim>()
    val claim: LiveData<RaffleClaim> = _claim

    fun loadClaim(claimId: String) {
        val ref = FirebaseDatabase.getInstance().getReference("claims/")
        ref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val data = snapshot.getValue(RaffleClaim::class.java)
                if (data != null) {
                    _claim.value = data
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Log or handle cancellation
            }
        })
    }
}

