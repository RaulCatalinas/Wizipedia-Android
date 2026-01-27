package com.example.wizipedia_android.ui.screens

// Compose
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Components
import com.example.wizipedia_android.components.CategoryCard

@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(4) { index ->
            when(index) {
                0 -> CategoryCard(
                    title = "Characters",
                    subtitle = "Wizards and Witches",
                    color = Color.Red
                )
                1 -> CategoryCard(
                    title = "Houses",
                    subtitle = "Sort yourself",
                    color = Color.Green
                )
                2 -> CategoryCard(
                    title = "Spells",
                    subtitle = "Charms and Hexes",
                    color = Color.Blue
                )
                3 -> CategoryCard(
                    title = "Media",
                    subtitle = "Books and Movies",
                    color = Color.Yellow
                )
            }
        }
    }
}
