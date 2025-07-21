package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import com.fire.adforge.model.Clan
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ClanViewModel : ViewModel() {

    private val db = FirebaseFirestore.getInstance()
    private val _clanData = MutableStateFlow<Clan?>(null)
    val clanData: StateFlow<Clan?> = _clanData

    init {
        fetchClan("user_test_id") //  Replace with real auth logic
    }

    private fun fetchClan(userId: String) {
        db.collection("clans").whereArrayContains("crewIds", "crew_test_id").get().addOnSuccessListener { snapshot ->
            if (!snapshot.isEmpty) {
                val clan = snapshot.first().toObject(Clan::class.java)
                _clanData.value = clan
            }
        }
    }
}
