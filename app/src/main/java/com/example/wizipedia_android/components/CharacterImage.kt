package com.example.wizipedia_android.components

// Android
import android.util.Log

// Compose
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// Coil
import coil3.compose.SubcomposeAsyncImage

@Composable
fun CharacterImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    size: Dp? = 60.dp,
    width: Dp? = null,
    height: Dp? = null,
    fillWidth: Boolean = false,
    shape: Shape = CircleShape,
    contentScale: ContentScale = ContentScale.Crop
) {
    val imageModifier = modifier.then(
        when {
            fillWidth && height != null -> Modifier
                .fillMaxWidth()
                .height(height)
                .clip(shape)

            width != null && height != null -> Modifier
                .size(width = width, height = height)
                .clip(shape)

            fillWidth -> Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(shape)

            size != null -> Modifier
                .size(size)
                .clip(shape)

            else -> Modifier.clip(shape)
        }
    )

    if (imageUrl.isBlank()) {
        Box(
            modifier = imageModifier.background(Color(0xFFE0E0E0)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = contentDescription ?: "No image available",
                tint = Color(0xFF9E9E9E),
                modifier = Modifier.size(
                    size?.div(2) ?: width?.div(2) ?: 32.dp
                )
            )
        }

        return
    }

    SubcomposeAsyncImage(
        model = imageUrl,
        contentDescription = contentDescription,
        contentScale = contentScale,
        modifier = imageModifier,
        loading = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFE0E0E0)),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    strokeWidth = 2.dp
                )
            }
        },
        error = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFE0E0E0)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Error loading image",
                    tint = Color(0xFF9E9E9E),
                    modifier = Modifier.size(32.dp)
                )
            }

            Log.e("CharacterImage", "Error loading image: $imageUrl", it.result.throwable)
        }
    )
}