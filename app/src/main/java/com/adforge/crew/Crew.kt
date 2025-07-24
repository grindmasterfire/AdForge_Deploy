package com.adforge.crew

data class Crew(
    val crewId: String,
    val members: MutableSet<String> = mutableSetOf()
)
