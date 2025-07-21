package com.fire.adforge.viewmodel

import com.fire.adforge.model.Clan
import com.google.firebase.firestore.FirebaseFirestore

class ClanManager {

    private val db = FirebaseFirestore.getInstance()

    fun createClan(clanName: String, crewIds: List<String>, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        if (crewIds.size < 5 || crewIds.size > 9) {
            onFailure(Exception("Clan must contain 5 to 9 crews"))
            return
        }

        val newClanRef = db.collection("clans").document()
        val clan = Clan(
            clanId = newClanRef.id,
            clanName = clanName,
            crewIds = crewIds
        )
        newClanRef.set(clan)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { e -> onFailure(e) }
    }

    fun checkAndBreakClan(clanId: String) {
        val clanRef = db.collection("clans").document(clanId)
        clanRef.get().addOnSuccessListener { snapshot ->
            val clan = snapshot.toObject(Clan::class.java)
            val currentSize = clan?.crewIds?.size ?: 0
            if (currentSize < 4) {
                clanRef.delete()
            }
        }
    }

    fun removeCrewFromClan(clanId: String, crewId: String) {
        val clanRef = db.collection("clans").document(clanId)
        clanRef.get().addOnSuccessListener { snapshot ->
            val clan = snapshot.toObject(Clan::class.java)
            clan?.let {
                val updatedCrews = it.crewIds.filterNot { id -> id == crewId }
                val updatedClan = it.copy(crewIds = updatedCrews)
                clanRef.set(updatedClan)
                if (updatedCrews.size < 4) {
                    clanRef.delete()
                }
            }
        }
    }
}
