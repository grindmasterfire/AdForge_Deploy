package com.fire.adforge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

data class UserDNA(
    val username: String = "",
    val totalCoins: Int = 0,
    val crew: String = "-",
    val referralCount: Int = 0,
    val badgeNames: List<String> = emptyList(),
    val milestones: Int = 0,
    val joinDate: String = "",
    val legacyLabel: String = "Unranked"
)

class UserDNAViewModel : ViewModel() {
    private val _dna = MutableStateFlow(UserDNA())
    val dna: StateFlow<UserDNA> = _dna

    private val db = FirebaseFirestore.getInstance()

    fun loadUserDNA(userId: String) {
        viewModelScope.launch {
            val userRef = db.collection("users").document(userId)
            val badgeRef = userRef.collection("badges")
            val referralRef = db.collection("referral_tree").document(userId)
            val milestoneRef = userRef.collection("milestones")

            userRef.get().addOnSuccessListener { doc ->
                val username = doc.getString("username") ?: "Unknown"
                val coins = (doc.getLong("totalCoins") ?: 0).toInt()
                val crew = doc.getString("crew") ?: "-"
                val join = doc.getTimestamp("created_at")?.toDate()?.let {
                    SimpleDateFormat("yyyy-MM-dd", Locale.US).format(it)
                } ?: "?"

                badgeRef.get().addOnSuccessListener { badges ->
                    val badgeList = badges.mapNotNull { it.getString("name") }

                    referralRef.get().addOnSuccessListener { refDoc ->
                        val referralCount = (refDoc.get("count") as? Long)?.toInt() ?: 0

                        milestoneRef.get().addOnSuccessListener { milestones ->
                            val milestoneCount = milestones.size()

                            val legacy = when {
                                coins > 25000 -> "Titan"
                                coins > 10000 -> "Legend"
                                coins > 3000 -> "Veteran"
                                coins > 500 -> "Rookie"
                                else -> "Initiate"
                            }

                            _dna.value = UserDNA(
                                username = username,
                                totalCoins = coins,
                                crew = crew,
                                referralCount = referralCount,
                                badgeNames = badgeList,
                                milestones = milestoneCount,
                                joinDate = join,
                                legacyLabel = legacy
                            )
                        }
                    }
                }
            }
        }
    }
}
