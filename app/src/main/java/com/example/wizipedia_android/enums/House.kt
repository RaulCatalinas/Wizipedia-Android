package com.example.wizipedia_android.enums

import androidx.compose.ui.graphics.Color

enum class House(
    val displayName: String,
    val backgroundColor: Color,
    val foregroundColor: Color,
    val description: String
) {
    GRYFFINDOR(
        displayName = "Gryffindor",
        backgroundColor = Color(0xFFAE0001),
        foregroundColor = Color(0xFFFFD700),
        description = "Courage & Bravery"
    ),
    HUFFLEPUFF(
        displayName = "Hufflepuff",
        backgroundColor = Color(0xFFECB939),
        foregroundColor = Color(0xFF000000),
        description = "Loyalty & Hard work"
    ),
    RAVENCLAW(
        displayName = "Ravenclaw",
        backgroundColor = Color(0xFF0E1A40),
        foregroundColor = Color(0xFFFFFFFF),
        description = "Wisdom & Wit"
    ),
    SLYTHERIN(
        displayName = "Slytherin",
        backgroundColor = Color(0xFF1A472A),
        foregroundColor = Color(0xFFFFFFFF),
        description = "Ambition & Cunning"
    ),
    UNKNOWN(
        displayName = "—",
        backgroundColor = Color(0xFF424242),
        foregroundColor = Color(0xFFBDBDBD),
        description = ""
    );

    companion object {
        fun fromString(house: String?): House {
            return when (house?.lowercase()) {
                "gryffindor" -> GRYFFINDOR
                "hufflepuff" -> HUFFLEPUFF
                "ravenclaw" -> RAVENCLAW
                "slytherin" -> SLYTHERIN
                else -> UNKNOWN
            }
        }
    }
}