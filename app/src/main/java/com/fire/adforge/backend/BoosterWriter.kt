package com.fire.adforge.backend

import com.fire.adforge.model.BoosterOffer
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

object BoosterWriter {

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    fun logBoosterPurchase(offer: BoosterOffer) {
        val uid = auth.currentUser?.uid ?: return
        db.collection("users")
            .document(uid)
            .collection("boosters")
            .add(offer)
    }
}
