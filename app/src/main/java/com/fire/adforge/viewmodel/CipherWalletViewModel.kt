package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class CipherWalletViewModel : ViewModel() {
    private val _walletStatus = MutableLiveData<String>("CipherWallet disabled (patched)")
    val walletStatus: LiveData<String> = _walletStatus
}
