package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class UserViewModel(private val auth: FirebaseAuth) : ViewModel() {
    fun getCurrentUserUid(): String? {
        return auth.currentUser?.uid
    }
}
