package com.fire.adforge.engine

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.Timestamp
import java.text.SimpleDateFormat
import java.util.*

object MemeForge {
    fun generatePost(): String {
        val templates = listOf(
            " Another day, another grind. Coins dont sleep.",
            " CipherBot's command: Earn or be earned.",
            " They said get a job... I built an empire.",
            " Win or lose, I never miss a raffle.",
            " Top badge, top crew, top tier. Stay forged.",
            " Time spent grinding is never wasted."
        )

        val today = SimpleDateFormat("EEEE", Locale.US).format(Date())
        val prefix = when (today) {
            "Monday" -> " MONDAY MODE:"
            "Friday" -> " FINAL FORM FRIDAY:"
            "Sunday" -> " REST? NEVER:"
            else -> " DAILY FOCUS:"
        }

        val pick = templates.random()
        return " "
    }

    suspend fun postToWall() {
        val db = FirebaseFirestore.getInstance()
        val post = hashMapOf(
            "authorId" to "CipherBot",
            "text" to generatePost(),
            "timestamp" to Timestamp.now()
        )

        db.collection("cipher_wall").add(post)
    }
}
