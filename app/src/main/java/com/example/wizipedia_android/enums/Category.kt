package com.example.wizipedia_android.enums

// Project
import com.example.wizipedia_android.R

// Compose
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// Colors
import com.example.wizipedia_android.ui.colors.createGradientColor

enum class Category(
    val title: String,
    val subtitle: String,
    val gradient: Brush,
    val iconId: Int
) {
    Characters(
        title = "Characters",
        subtitle = "Discover the wizards",
        gradient = createGradientColor(
            Color(0xFF6B1A1A),
            Color(0xFF3A0F0F),
            Color(0xFF120606)
        ),
        iconId = R.drawable.characters
    ),
    Houses(
        title = "Houses",
        subtitle = "Hogwarts houses",
        gradient = createGradientColor(
            Color(0xFF244638),
            Color(0xFF162C23),
            Color(0xFF0B1713)
        ),
        iconId = R.drawable.houses
    ),
    Spells(
        title = "Spells",
        subtitle = "Magical spells",
        gradient = createGradientColor(
            Color(0xFF222E45),
            Color(0xFF141C2E),
            Color(0xFF0A0F1C)
        ),
        iconId = R.drawable.spells
    ),
    Media(
        title = "Media",
        subtitle = "Movies & books",
        gradient = createGradientColor(
            Color(0xFF6A5A22),
            Color(0xFF3D3314),
            Color(0xFF1C1809)
        ),
        iconId = R.drawable.media
    )
}

