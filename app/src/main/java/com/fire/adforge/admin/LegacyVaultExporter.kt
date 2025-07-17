package com.fire.adforge.admin

import com.google.firebase.database.*
import java.text.SimpleDateFormat
import java.util.*

class LegacyVaultExporter {

    private val db = FirebaseDatabase.getInstance()
    private val exportRoot = db.getReference("exports")

    fun exportAll(onComplete: (Boolean) -> Unit) {
        val timestamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val exportPath = exportRoot.child("raffleSnapshot_\")

        val dataMap = mutableMapOf<String, Any>()

        val refs = listOf(
            "raffleJournal",
            "payoutQueue",
            "crewScores"
        )

        val pending = refs.size
        var done = 0
        var failed = false

        refs.forEach { path ->
            db.getReference(path).addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    dataMap["\.json"] = snapshot.value ?: emptyMap<String, Any>()
                    done++
                    if (done == pending && !failed) {
                        exportPath.setValue(dataMap)
                            .addOnSuccessListener { onComplete(true) }
                            .addOnFailureListener { onComplete(false) }
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    failed = true
                    onComplete(false)
                }
            })
        }
    }
}
