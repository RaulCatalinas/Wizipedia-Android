package com.example.wizipedia_android.components

// Annotations
import androidx.annotation.DrawableRes

// Compose
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun RenderLocalImage(
    @DrawableRes drawableResId: Int,
    modifier: Modifier = Modifier,
    colorTint: Color = Color.White
) {
    Icon(
        painter = painterResource(drawableResId),
        modifier = modifier.size(25.dp),
        contentDescription = "Category icon",
        tint = colorTint
    )
}

