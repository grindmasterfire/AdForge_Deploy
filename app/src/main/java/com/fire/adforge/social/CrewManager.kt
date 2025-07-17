import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.social

object CrewManager {
    private val crews = mutableMapOf<String, Crew>()

    fun createCrew(id: String, name: String, creator: String): Crew {
        val crew = Crew(id, name, listOf(creator), 0)
        crews[id] = crew
        return crew
    }

    fun addMemberToCrew(crewId: String, userId: String): Boolean {
        val crew = crews[crewId] ?: return false
        if (!crew.members.contains(userId)) {
            crews[crewId] = crew.copy(members = crew.members + userId)
            return true
        }
        return false
    }

    fun awardPoints(crewId: String, points: Int) {
        crews[crewId]?.let {
            crews[crewId] = it.copy(totalPoints = it.totalPoints + points)
        }
    }

    fun getCrew(crewId: String): Crew? = crews[crewId]
}

