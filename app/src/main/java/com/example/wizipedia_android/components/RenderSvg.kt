package com.example.wizipedia_android.components

import android.util.Log
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage

@Composable
fun RenderSvg(
    drawableResId: Int,
    modifier: Modifier = Modifier
) {
    SubcomposeAsyncImage(
        model = drawableResId,
        contentDescription = "Category icon",
        modifier = modifier.size(25.dp),
        loading = {
            CircularProgressIndicator(strokeWidth = 2.dp)
        },
        onError = {
            Log.e("RenderSvg", "Error loading svg: ${it.result}", it.result.throwable)
        }
    )
}

