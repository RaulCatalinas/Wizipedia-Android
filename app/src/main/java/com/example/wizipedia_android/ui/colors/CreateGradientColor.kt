package com.example.wizipedia_android.ui.colors

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush

fun createGradientColor(
    initialColor: Color,
    intermediateColor: Color,
    endColor: Color,
): Brush {
    return Brush.verticalGradient(
        colorStops = arrayOf(
            0.0f to initialColor,
            0.5f to intermediateColor,
            1.0f to endColor
        )
    )
}