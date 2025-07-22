package com.fire.adforge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.auth.FirebaseAuth

class CipherWalletViewModel : ViewModel() {
    private val _coinBalance = MutableLiveData<Int>()
    val coinBalance: LiveData<Int> = _coinBalance

    private val _walletStatus = MutableLiveData<String>()
    val walletStatus: LiveData<String> = _walletStatus

    private val firestore = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    init {
        loadWalletData()
    }

    private fun loadWalletData() {
        val uid = auth.currentUser?.uid
        if (uid == null) {
            _walletStatus.value = "User not signed in"
            return
        }

        firestore.collection("wallets").document(uid)
            .get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    val coins = document.getLong("coins")?.toInt() ?: 0
                    _coinBalance.value = coins
                    _walletStatus.value = "Wallet synced"
                } else {
                    _walletStatus.value = "Wallet not found"
                    _coinBalance.value = 0
                }
            }
            .addOnFailureListener {
                _walletStatus.value = "Error loading wallet"
                _coinBalance.value = 0
            }
    }
}
